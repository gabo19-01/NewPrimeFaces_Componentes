/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import correo.Evento;
import Servicios.CalendarioServicio;
import correo.Alerta;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import org.primefaces.manhattan.view.data.ScheduleJava8View;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

/**
 *
 * @author gabri
 */
@ManagedBean(name = "calendarioController")
@RequestScoped
public class calendarioController implements Serializable {

    @ManagedProperty("#{loginController}")
    private LoginController loginController;

    CalendarioServicio calendarioServicio = new CalendarioServicio();

    private ScheduleJava8View sj8v;
    private checkBoxController cbc;

    private String nombreEvento;
    private LocalDate fechaInicio;

    private ScheduleModel eventModel;

    private String[] intervalos = {"Diariamente", "Semanalmente", "Mensualmente"};

    private String intervaloSeleccionado;

    private int idEventoInsertado;
    private Evento nuevoEvento;

    private ScheduleEvent event = new DefaultScheduleEvent();

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public ScheduleModel getEventModel() {
        return eventModel;
    }

    public void setEventModel(ScheduleModel eventModel) {
        this.eventModel = eventModel;
    }

    public ScheduleEvent getEvent() {
        return event;
    }

    public void setEvent(ScheduleEvent event) {
        this.event = event;
    }

    public String[] getIntervalos() {
        return intervalos;
    }

    public void setIntervalos(String[] intervalos) {
        this.intervalos = intervalos;
    }

    public String getIntervaloSeleccionado() {
        return intervaloSeleccionado;
    }

    public void setIntervaloSeleccionado(String intervaloSeleccionado) {
        this.intervaloSeleccionado = intervaloSeleccionado;
    }

    public int getIdEventoInsertado() {
        return idEventoInsertado;
    }

    public void setIdEventoInsertado(int idEventoInsertado) {
        this.idEventoInsertado = idEventoInsertado;
    }

    public Evento getNuevoEvento() {
        return nuevoEvento;
    }

    public void setNuevoEvento(Evento nuevoEvento) {
        this.nuevoEvento = nuevoEvento;
    }

    public LoginController getLoginController() {
        return loginController;
    }

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }
    
    public void addEvent() {

        if (event.isAllDay()) {
            //see https://github.com/primefaces/primefaces/issues/1164
            if (event.getStartDate().toLocalDate().equals(event.getEndDate().toLocalDate())) {
                event.setEndDate(event.getEndDate().plusDays(1));
            }
        }

        if (event.getId() == null) {
            eventModel.addEvent(event);
        } else {
            eventModel.updateEvent(event);
        }


        sj8v.setParticipantes(Arrays.asList(cbc.getSelectedCorreos()));

        nuevoEvento.setCompletado((byte) 1);
        nuevoEvento.setUsuario(loginController.getUsuarioLoggeado());
        nuevoEvento.setDescripcion(event.getDescription());
        nuevoEvento.setParticipantes("Prueba"); 
        //******* Este campo deberia de ser una Tabla nueva, porque 1 Evento puede tener Muchos Participantes
        nuevoEvento.setTiempoFin(Date.valueOf(event.getEndDate().toLocalDate()));
        nuevoEvento.setTiempoInicio(Date.valueOf(event.getStartDate().toLocalDate()));
        nuevoEvento.setTitulo(event.getTitle());
        nuevoEvento.setEventoID(calendarioServicio.insertEvent(nuevoEvento));
 
        this.crearAlerta(event);
    }

    public void crearAlerta(ScheduleEvent event) {
        Alerta nuevaAlerta = null;
        Date d = Date.valueOf(event.getStartDate().plusDays(1).toLocalDate());
        switch (this.intervaloSeleccionado) {

            case "Diariamente":
                nuevaAlerta = new Alerta();
                nuevaAlerta.setFechaFinal(Date.valueOf(event.getEndDate().toLocalDate()));
                nuevaAlerta.setFechaProx(Date.valueOf(event.getStartDate().plusDays(1).toLocalDate()));
                nuevaAlerta.setEvento(this.getNuevoEvento());
                nuevaAlerta.setIntervalo(1);
                nuevaAlerta.setNombreAlerta(event.getTitle());
                break;

            case "Semanalmente":
                nuevaAlerta = new Alerta();
                nuevaAlerta.setFechaFinal(Date.valueOf(event.getEndDate().toLocalDate()));
                nuevaAlerta.setFechaProx(Date.valueOf(event.getStartDate().plusWeeks(1).toLocalDate()));
                nuevaAlerta.setEvento(this.getNuevoEvento());
                nuevaAlerta.setIntervalo(1);
                nuevaAlerta.setNombreAlerta(event.getTitle());
                break;

            case "Mensualmente":
                nuevaAlerta = new Alerta();
                nuevaAlerta.setFechaFinal(Date.valueOf(event.getEndDate().toLocalDate()));
                nuevaAlerta.setFechaProx(Date.valueOf(event.getStartDate().plusMonths(1).toLocalDate()));
                nuevaAlerta.setEvento(this.getNuevoEvento());
                nuevaAlerta.setIntervalo(1);
                nuevaAlerta.setNombreAlerta(event.getTitle());
                break;
        }
        calendarioServicio.insertAlerta(nuevaAlerta);
    }

    

}
