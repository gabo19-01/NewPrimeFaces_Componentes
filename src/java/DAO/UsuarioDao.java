package DAO;

import componentes.Usuario;
import util.EntityManagerU;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class UsuarioDao implements UsDao {

    private final EntityManager entityManager;

    public UsuarioDao() {
        this.entityManager = EntityManagerU.getEntityManager("componentes");
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.clear();
        List<Usuario> list = entityManager.createQuery("select u from Usuario u").getResultList();
        transaction.commit();
        return list;
    }

    @Override
    public Usuario getUsuarioById(int idUsuario) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Usuario user = entityManager.find(Usuario.class, idUsuario);
        transaction.commit();
        return user;
    }

    @Override
    public Usuario getUsuarioByData(String correo, String contrasena) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Query query = entityManager.createQuery("select u from Usuario u where u.correo =:correo and u.contrasena =:contrasena");
        query.setParameter("correo", correo);
        query.setParameter("contrasena", contrasena);
        Usuario user = (Usuario) query.getSingleResult();
//        Usuario user = (Usuario) query.getResultList().get(0);
        transaction.commit();
        return user;
    }

    @Override
    public boolean agregarUsuario(String nombre, String correo, String contrasena) {
//       Usuario userToAdd = new Usuario(nombre, correo, contrasena);
	Usuario userToAdd = new Usuario();
	userToAdd.setNombre(nombre);
	userToAdd.setCorreo(correo);
	userToAdd.setContrasena(contrasena);
        for (Usuario user : this.getAllUsuarios()){
           if (user.equals(userToAdd)) return false;
       }
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(userToAdd);
        transaction.commit();
        return true;
    }

    @Override
    public void modificarUsuario(int idUsuario, String nombre, String correo, String contrasena) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Usuario user = entityManager.find(Usuario.class, idUsuario);
        user.setNombre(nombre);
        user.setCorreo(correo);
        user.setContrasena(contrasena);
        entityManager.merge(user);
        transaction.commit();
    }

    @Override
    public void eliminarUsuarioById(int idUsuario) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Usuario user = entityManager.find(Usuario.class, idUsuario);
        entityManager.remove(user);
        transaction.commit();
    }

    
   
}
