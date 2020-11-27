/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelo.Usuario;
import Servicios.LoginServicio;
import java.io.IOException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

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

    public boolean verificar() {
        boolean retorno = false;
        List<Usuario> usuarios = ls.allUsuarios();
        for (Usuario u : usuarios) {
            if (u.getCorreo().equals(usuario) && u.getContrasenha().equals(contrasenha)) {
                retorno = true;
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
        if (this.verificar()) {
            this.redirect("Comprar.xhtml");
        } else {
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Usuario o password incorrectos"));
        }
    }
}
