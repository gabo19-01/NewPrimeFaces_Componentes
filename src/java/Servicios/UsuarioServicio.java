/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import DAO.UsuarioDao;
import correo.Usuario;

/**
 *
 * @author mike
 */
public class UsuarioServicio {
    
    private UsuarioDao usuarioDAO;
    
    public UsuarioServicio(){
        
    }
    
    
    public String getNombreUsuarioPorID(Usuario usuario){
        //Usuario usuario = usuarioDAO.getUsuarioById(id);
        String nombre = usuario.getNombre();        
        return nombre;
    }
    
    
    
    
}//EndOfClass
