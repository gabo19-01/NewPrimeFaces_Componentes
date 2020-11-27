/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelo.Evento;
import Servicios.CalendarioServicio;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import javax.faces.bean.ManagedBean;
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

    CalendarioServicio calendarioSerivicio = new CalendarioServicio();
    
    private ScheduleJava8View sj8v;
    private checkBoxController cbc;
    
    private String nombreEvento;
    private LocalDate fechaInicio;

    private ScheduleModel eventModel;

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

        event = new DefaultScheduleEvent();
        System.out.println(this.event.getTitle());

       
            sj8v.setParticipantes(Arrays.asList(cbc.getSelectedCorreos()));

        
        Evento evento = new Evento(event.getStartDate(), event.getEndDate(), event.getTitle(), event.getDescription(), false, sj8v.getParticipantes());
       
        calendarioSerivicio.insertEvent(evento);
    }

}
