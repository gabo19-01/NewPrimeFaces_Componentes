package DAO;

import componentes.Usuario;

import java.util.List;

public interface UsDao {
    List<Usuario> getAllUsuarios();
    Usuario getUsuarioById(int idUsuario);
    Usuario getUsuarioByData(String correo, String contrasena);
    boolean agregarUsuario(String nombre, String correo, String contrasena);
    void modificarUsuario(int idUsuario, String nombre, String correo, String contrasena);
    void eliminarUsuarioById(int idUsuario);
  
}
