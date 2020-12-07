/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import correo.Evento;
import correo.Usuario;
import Servicios.EventoServicio;
import Servicios.UsuarioServicio;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import org.primefaces.manhattan.view.data.ScheduleJava8View;
import org.primefaces.model.*;

/**
 *
 * @author gabri
 */
@ManagedBean(name = "calendarioController")
@RequestScoped
public class calendarioController implements Serializable {
       
    private ScheduleJava8View sj8v;
    private checkBoxController cbc;
    
    private String nombreEvento;
    private LocalDate fechaInicio;
    private Usuario usuario;

    private ScheduleModel eventModel;
    private ScheduleEvent event = new DefaultScheduleEvent();
    
    UsuarioServicio usuarioServicio = new UsuarioServicio();
    
    @ManagedProperty("#{loginController}")
    private LoginController loginController;
    
    private EventoServicio eventoServicio;
    

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

//    public void addEvent() {
//        if (event.isAllDay()) {
//            //see https://github.com/primefaces/primefaces/issues/1164
//            if (event.getStartDate().toLocalDate().equals(event.getEndDate().toLocalDate())) {
//                event.setEndDate(event.getEndDate().plusDays(1));
//            }
//        }
//
//        if (event.getId() == null) {
//            eventModel.addEvent(event);
//        } else {
//            eventModel.updateEvent(event);
//        }
//
//        event = new DefaultScheduleEvent();
//        System.out.println(this.event.getTitle());
//
//       
//            sj8v.setParticipantes(Arrays.asList(cbc.getSelectedCorreos()));
//
//        
//        Evento evento = new Evento(event.getStartDate(), event.getEndDate(), event.getTitle(), event.getDescription(), false, sj8v.getParticipantes());
//       
//        calendarioSerivicio.insertEvent(evento);
//    }
//    
    
    /*
    Metodo que se ejecuta justo despues de instanciar una clase de calendarioController, Esta llena en la lista de objetos de tipo Evento, todos
    los eventos asociados con el Usuario, se llama desde la vista data.xhtml
    */
    @PostConstruct
    private void getEventosUsuario(){
        List<Evento> eventos = eventoServicio.getEventosUsuario(loginController.getUsuarioLoggeado());
        popularModelo(eventos);
        
    }
    
    
    /* Metodo que traduce el evento que se envie como parametro a "ScheduleEvent" 
    input -> evento:Evento
    output -> eventoTraducido: DefaultScheduleEvent
    */    
    private DefaultScheduleEvent traducirEvento(Evento evento){
        LocalDateTime inicio = LocalDateTime.ofInstant(evento.getTiempoInicio().toInstant(), ZoneId.systemDefault());
        LocalDateTime fin = LocalDateTime.ofInstant(evento.getTiempoFin().toInstant(), ZoneId.systemDefault());
        
        
        DefaultScheduleEvent eventoTraducido = DefaultScheduleEvent.builder()
				.title(evento.getTitulo())
				.startDate(inicio)
				.endDate(fin)
				.description("Creador: "+ usuarioServicio.getNombreUsuarioPorID(evento.getUsuario()) +"\n"
                                        + evento.getDescripcion() + "\n Participantes: " + evento.getParticipantes()
                                        )                                
				.build();
        return eventoTraducido;        
    }
    
    /*
    Metodo que se encarga de iterarar sobre la lista de eventos que se le envie como parametro, traducirlos al tipo
    DefaultScheduleEvent y luego popular el Modelo de eventos 'eventModel'
    input -> eventos:List<Evento>
    output -> ninguno
    */
    public void popularModelo(List<Evento> eventos){
        for(Evento evento : eventos){
            DefaultScheduleEvent eventoTraducido = traducirEvento(evento);
            eventModel.addEvent(eventoTraducido);            
        }
    } 
    

}//ENDOFCLASS
