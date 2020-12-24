/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Servicios.LoginServicio;
import componentes.Departamento;
import java.io.IOException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import componentes.Usuario;

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
    private boolean administrar = false;

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
            this.administrar = false;
            this.redirect("pagina_principal.xhtml");
            
        }else if(usuario.equals("admin") && contrasenha.equals("admin")){
            this.administrar = true;
            this.redirect("administrar_usuarios.xhtml");
        }else {
        
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Usuario o password incorrectos"));
        }
    }
    
    public boolean puedeAdministrar(){
        return this.administrar;
    }
    
    public boolean tieneDepartamentos(){
        boolean variosDepartamentos;
        
        if(ls.getDepartamentosByID(this.usuarioLoggeado.getUsuarioID()).size() >= 2){
            variosDepartamentos = true;
        }else {
            variosDepartamentos = false;
        }
        
        return variosDepartamentos;
    }
    
    public List<String> llenarDeparatamentos(){
        List<String> nombresDepartamentos = null;
        for(Departamento d : ls.getDepartamentosByID(this.usuarioLoggeado.getUsuarioID())){
            nombresDepartamentos.add(d.getNombreDepartamento());
        }
        return nombresDepartamentos;
    }
    public void redireccionPagPrincipal(){
        this.redirect("");
    }
    
    public void redireccionCalendario() {
        this.redirect("data.xhtml");
    }
    public void redireccionComprar() {
        this.redirect("comprar.xhtml");
    }
    public void redireccionBitacora() {
        this.redirect("bitacora.xhtml");
    }
    public void redireccionInventario() {
        this.redirect("inventario.xhtml");
    }
    public void redireccionAdministrar() {
        this.redirect("administrar_usuarios.xhtml");
    }
    public void redireccionEventos(){
        this.redirect("data.xhtml");
    }

    public boolean isAdministrar() {
        return administrar;
    }

    public void setAdministrar(boolean administrar) {
        this.administrar = administrar;
    }
    
    

}
