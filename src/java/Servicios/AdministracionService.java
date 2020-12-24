
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import static Servicios.LoginServicio.startEntityManagerFactory;
import static Servicios.LoginServicio.stopEntityManagerFactory;
import componentes.Departamento;
import componentes.Evento;
import componentes.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transactional;

/**
 *
 * @author Pablo Porras
 */

@ManagedBean(name = "administracionService", eager=true)
@ApplicationScoped

public class AdministracionService implements Serializable {

    private static EntityManager em = null;
    private static EntityManagerFactory entityManagerFactory = null;

    public AdministracionService() {
    }

    // Metodo que se encarga de crear la entidad.
    public static void startEntityManagerFactory() {
        if (entityManagerFactory == null) {
            try {
                entityManagerFactory = Persistence.createEntityManagerFactory("componentes");
                em = entityManagerFactory.createEntityManager();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // Metodo que se encarga de detener el entity manager
    public static void stopEntityManagerFactory() {
        if (entityManagerFactory != null) {
            if (entityManagerFactory.isOpen()) {
                try {
                    entityManagerFactory.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            em.close();
            entityManagerFactory = null;
        }
    }

    
    public List<Departamento> allDepartamentos() {
        this.startEntityManagerFactory();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.clear();
        List<Departamento> list = em.createQuery("SELECT d FROM Departamento d").getResultList();
        transaction.commit();
        this.stopEntityManagerFactory();
        return list;
    }

    
    public void updateUsuario(Usuario u) {
        this.startEntityManagerFactory();
        Usuario usuarioSinActualizar = em.find(Usuario.class, u.getUsuarioID());
        em.getTransaction().begin();
        usuarioSinActualizar.setContrasena(u.getContrasena());
        usuarioSinActualizar.setCorreo(u.getCorreo());
        usuarioSinActualizar.setNombre(u.getNombre());
        //usuarioSinActualizar.setDepartamentos(u.getDepartamentos());
        em.getTransaction().commit();
        this.stopEntityManagerFactory();
    }

    /*public List<Departamento> usuarioDepartamentosID(Usuario u) {
        this.startEntityManagerFactory();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.clear();
        List<Integer> list = em.createQuery("SELECT departamentoID FROM usuario_departamento WHERE usuarioID = "
                + u.getUsuarioID()).getResultList();
        transaction.commit();

        List<Departamento> listaNombres = this.usuarioDepartamentosNombre(list);
        this.stopEntityManagerFactory();
        return listaNombres;
    }*/
    
    @Transactional
    public List<Departamento> getDepartamentosByID(int loggeadoID){
       List<Departamento> departamentos;
       startEntityManagerFactory();
       em.getTransaction().begin();
       departamentos = em.find(Usuario.class, loggeadoID).getDepartamentos();
       em.getTransaction().commit();
       stopEntityManagerFactory();
       return departamentos;
    }

    //Llamado por metodo de arriba
    public List<Departamento> usuarioDepartamentosNombre(List<Integer> departamentosIDs) {
        this.startEntityManagerFactory();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.clear();
        List<Departamento> list = em.createQuery("SELECT FROM Departamento d WHERE ").getResultList();
        transaction.commit();
        this.stopEntityManagerFactory();
        return list;
    }

    public void insertUsuario(Usuario usu){
        this.startEntityManagerFactory();
        this.em.getTransaction().begin();
        this.em.persist(usu);
        this.em.flush();
        this.em.getTransaction().commit();
        this.stopEntityManagerFactory();
    }

    
    public void updateDepartamentos(Usuario u, List<Departamento> departamentosNuevos) {
        this.startEntityManagerFactory();
        em.createQuery("DELETE FROM usuario_departamento WHERE usuarioID = :usuarioID")
                .setParameter("usuarioID", u.getUsuarioID())
                .executeUpdate();

        for (Departamento d : departamentosNuevos) {
            Query query = em.createQuery("INSERT INTO usuario_departamento (usuarioID, departamentoID) VALUES (:usuarioID, :departamentoID)");
            query.setParameter("usuarioID", u.getUsuarioID());
            query.setParameter("departamentoID", d.getDepartamentoID());
            query.executeUpdate();

        }
        this.stopEntityManagerFactory();
    }
    
    public void deleteUsuario(Usuario usu){
        this.startEntityManagerFactory();
        Usuario u = em.find(Usuario.class, usu.getUsuarioID());
        em.getTransaction().begin();
        em.remove(u);
        em.getTransaction().commit();
        this.stopEntityManagerFactory();
    }
    
    
}