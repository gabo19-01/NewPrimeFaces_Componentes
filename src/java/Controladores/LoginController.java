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
import correo.Usuario;

/**
 *
 * @author gabri
 */
@ManagedBean(name = "loginController")
@SessionScoped
public class LoginController {

    LoginServicio ls = new LoginServicio();
    private String usuario;
    private String contrasenha;

    private Usuario usuarioLoggeado;
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }
    
    public Usuario getUsuarioLoggeado() {
        return usuarioLoggeado;
    }

    public void setUsuarioLoggeado(Usuario usuarioLoggeado) {
        this.usuarioLoggeado = usuarioLoggeado;
    }
    
    

    public boolean verificar() {
        boolean retorno = false; 
        List<Usuario> usuarios = ls.allUsuarios();
        for (Usuario u : usuarios) {
            if (u.getCorreo().equals(usuario) && u.getContrasena().equals(contrasenha)) {
                retorno = true;
                this.usuarioLoggeado = u;
                break;
            } else {
                retorno = false;
            }
        }
        return retorno;
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

    public void iniciarSesion() {
        ls.startEntityManagerFactory();
        if (this.verificar()) {
            this.redirect("inventario.xhtml");
        } else {
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Usuario o password incorrectos"));
        }
    }
    public void redireccionCalendario(String pagina) {
        this.redirect("data.xhtml");
    }
    public void redireccionComprar(String pagina) {
        this.redirect("comprar.xhtml");
    }

}
