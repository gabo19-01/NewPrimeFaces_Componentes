package Servicios;

import DAO.UsDao;
import DAO.UsuarioDao;
import correo.Usuario;

import java.util.List;

public class ServicioUsuario implements UsDao {

    private final UsDao usDao;

    public ServicioUsuario() {
        this.usDao = new UsuarioDao();
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        return usDao.getAllUsuarios();
    }

    @Override
    public Usuario getUsuarioById(int idUsuario) {
        return usDao.getUsuarioById(idUsuario);
    }

    @Override
    public Usuario getUsuarioByData(String correo, String contrasena) {
        return usDao.getUsuarioByData(correo,contrasena);
    }

    @Override
    public boolean agregarUsuario(String nombre, String correo, String contrasena) {
        return usDao.agregarUsuario(nombre,correo,contrasena);
    }

    @Override
    public void modificarUsuario(int idUsuario, String nombre, String correo, String contrasena) {
        usDao.modificarUsuario(idUsuario,nombre,correo,contrasena);
    }

    @Override
    public void eliminarUsuarioById(int idUsuario) {
        usDao.eliminarUsuarioById(idUsuario);
    }

    public List<Usuario> getAllUsers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
}
