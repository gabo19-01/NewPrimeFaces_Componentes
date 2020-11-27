/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author gabri
 */
public class Usuario {
    //Atributos
    private int id;
    private String nombre;
    //FALTA Atributo departamento de tipo Departamento
    private String Correo;
    private String Contrasenha;
    
    //Constructores
    public Usuario() {
    }
    
    public Usuario(int id, String nombre, String Correo, String Contrasenha) {
        this.id = id;
        this.nombre = nombre;
        this.Correo = Correo;
        this.Contrasenha = Contrasenha;
    }
    
    //Set's y Get's
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getContrasenha() {
        return Contrasenha;
    }

    public void setContrasenha(String Contrasenha) {
        this.Contrasenha = Contrasenha;
    }
 
}
