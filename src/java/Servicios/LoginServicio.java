/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;


import componentes.Departamento;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.*;
import componentes.Usuario;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author gabri
 */
public class LoginServicio {

    private List<Usuario> usuarios;

    private static EntityManagerFactory entityManagerFactory = null;
    private static EntityManager em = null;

	public LoginServicio() {
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

    public List<Usuario> allUsuarios() {
        startEntityManagerFactory();
        TypedQuery<Usuario> query;
        query = em.createQuery("SELECT u FROM Usuario u", Usuario.class);
        List<Usuario> usuarios = query.getResultList();
        stopEntityManagerFactory();
        return usuarios;
    }

    public Usuario getUsuarioById(int id) {
        startEntityManagerFactory();
        Usuario usuario = em.find(Usuario.class, id) ;
        stopEntityManagerFactory();
        return usuario;

    }

    public List<Departamento> getDepartamentosByID(int loggeadoID){
       List<Departamento> departamentos;
       startEntityManagerFactory();
       departamentos = em.find(Usuario.class, loggeadoID).getDepartamentos();
       stopEntityManagerFactory();
       return departamentos;
    }
}
