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
import componentes.Producto;
import Servicios.ProductoServicio;
import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author carlossimpsonglaston
 */
@ManagedBean(name = "productoController")
@SessionScoped
public class ProductoController implements Serializable{
    ProductoServicio ps = new ProductoServicio();
    private Producto productoSeleccionado;

    public Producto getProductoSeleccionado() {
        return productoSeleccionado;
    }

    public void setProductoSeleccionado(Producto productoSeleccionado) {
        this.productoSeleccionado = productoSeleccionado;
    }
    public void redirect(String url) {
        try {
            HttpServletRequest request = (HttpServletRequest) FacesContext
                    .getCurrentInstance().getExternalContext().getRequest();
            FacesContext
                    .getCurrentInstance()
                    .getExternalContext()
                    .redirect(
                            request.getContextPath()
                            + "/" + url);
        } catch (IOException e) {
            System.out.println("No se pudo rediredonaresfacilonar " + e);
        }
    }
    public List<Producto> allProductos() {
        List<Producto> productos = ps.allProductos();
        return productos;
    }
    public void redireccionComprar() {
        this.redirect("comprar.xhtml");
    }
}
