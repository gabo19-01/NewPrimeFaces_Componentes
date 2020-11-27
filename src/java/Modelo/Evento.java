/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author gabri
 */
public class Evento {
    private LocalDateTime tiempoInicio;
    private LocalDateTime tiempoFin;
    //Falta el atributo creador de tipo Usuario
    private String titulo;
    private String descripcion;
    //Falta el atributo departamento de tipo Departamento
    //Falta Adjuntos de tipo List<adjuntos> (Shamuel)
    private boolean completado;
    private List<String> participantes;
    //Falta el atributo alerta de tipo alerta

    //Constructores
    public Evento() {
    }

    public Evento(LocalDateTime tiempoInicio, LocalDateTime tiempoFin, String titulo, String descripcion, boolean completado, List<String> participantes) {
        this.tiempoInicio = tiempoInicio;
        this.tiempoFin = tiempoFin;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.completado = completado;
        this.participantes = participantes;
    }
    
    //Set's y Get's
    public LocalDateTime getTiempoInicio() {
        return tiempoInicio;
    }

    public void setTiempoInicio(LocalDateTime tiempoInicio) {
        this.tiempoInicio = tiempoInicio;
    }

    public LocalDateTime getTiempoFin() {
        return tiempoFin;
    }

    public void setTiempoFin(LocalDateTime tiempoFin) {
        this.tiempoFin = tiempoFin;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isCompletado() {
        return completado;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }

    public List<String> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<String> participantes) {
        this.participantes = participantes;
    }
    
}
