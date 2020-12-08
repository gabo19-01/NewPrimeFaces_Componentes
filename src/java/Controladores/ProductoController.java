/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Servicios.LoginServicio;
import java.io.IOException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import facturacion.Producto;
import Servicios.ProductoServicio;
/**
 *
 * @author carlossimpsonglaston
 */
@ManagedBean(name = "productoController")
@SessionScoped
public class ProductoController {
    private String descripcion;
    private double precioPorMenor;
    private String nombre;
    ProductoServicio ps = new ProductoServicio();
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioPorMenor() {
        return precioPorMenor;
    }

    public void setPrecioPorMenor(double precioPorMenor) {
        this.precioPorMenor = precioPorMenor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Producto> allProductos() {
        List<Producto> productos = ps.allProductos();
        return productos;
    }
}
