/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

//import DAO.UsuarioDao;
import Servicios.AdministracionService;
import Servicios.ServicioUsuario;
import componentes.Departamento;
import componentes.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
//import javax.faces.bean.RequestScoped;
//import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
//import javax.inject.Named;
//import javax.persistence.EntityManager;

/**
 *
 * @author Pablo Porras
 */
@Named
@ViewScoped
public class AdministracionController implements Serializable {
//    private static EntityManager em = null;
    
    private static final long serialVersionUID = 1L;
    
    private ServicioUsuario servicioUsuario;
    
    private Usuario selectedUsuario;
    
    public Usuario getSelectedUsuario() {
        return selectedUsuario;
    }
    
    public void setSelectedUsuario(Usuario selectedUsuario) {
        this.selectedUsuario = selectedUsuario;
    }
    private List<Departamento> departamentosInsert;

//    @Inject
    private AdministracionService administracionService;
    private List<Departamento> allDepartamentos;
    private List<Departamento> usuarioDepartamentos;
    
    private Usuario nuevoUsuario;
    
    public AdministracionController() {
    }
    
    private List<Usuario> allUsuarios;
    
    @PostConstruct
    public void init() {
        this.servicioUsuario = new ServicioUsuario();
        this.administracionService = new AdministracionService();
        this.autoRellenar();
    }
    
    public void autoRellenar() {
        this.allUsuarios = servicioUsuario.getAllUsuarios();
        this.allDepartamentos = administracionService.allDepartamentos();
    }

    public void llenarUsuarioDepartamentos() {
        this.usuarioDepartamentos = administracionService.usuarioDepartamentosID(selectedUsuario);
    }
    
    public void deleteUsuario() {
        servicioUsuario.eliminarUsuarioById(this.selectedUsuario.getUsuarioID());
    }
    
    public void insertUsuario() {
//        administracionService.insertUsuario(nuevoUsuario, departamentosInsert);
    }
    
    public void updateUsuario() {
        this.selectedUsuario.setDepartamentos(this.usuarioDepartamentos);
        administracionService.updateUsuario(selectedUsuario);
    }
    
    public List<Usuario> getAllUsuarios() {
        return allUsuarios;
    }
    
    public void setAllUsuarios(List<Usuario> allUsuarios) {
        this.allUsuarios = allUsuarios;
    }
    
    public List<Departamento> getDepartamentosInsert() {
        return departamentosInsert;
    }
    
    public void setDepartamentosInsert(List<Departamento> departamentosInsert) {
        this.departamentosInsert = departamentosInsert;
    }
    
    public List<Departamento> getAllDepartamentos() {
        return allDepartamentos;
    }
    
    public void setAllDepartamentos(List<Departamento> allDepartamentos) {
        this.allDepartamentos = allDepartamentos;
    }
    
    public List<Departamento> getUsuarioDepartamentos() {
        return usuarioDepartamentos;
    }
    
    public void setUsuarioDepartamentos(List<Departamento> usuarioDepartamentos) {
        this.usuarioDepartamentos = usuarioDepartamentos;
    }
    
    public Usuario getNuevoUsuario() {
        return nuevoUsuario;
    }
    
    public void setNuevoUsuario(Usuario nuevoUsuario) {
        this.nuevoUsuario = nuevoUsuario;
    }
    
}
