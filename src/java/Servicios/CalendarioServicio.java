/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Modelo.Evento;
import javax.transaction.Transactional;

/**
 *
 * @author gabri
 */
public class CalendarioServicio {
    
    @Transactional
    public void insertEvent(Evento evento){
       /* entityManager.createNativeQuery("INSERT INTO Evento (tiempoInicio, tiempoFin, creador, titulo, descripcion, departamento, adjuntos, completado, Participantes, tipoAlerta) VALUES (?,?,?,?,?,?,?,?,?,?)")
.setParameter(1, evento.getTiempoInicio())
.setParameter(2, evento.getTiempoFin())
.setParameter(3, evento.getCreador())
.setParameter(4, evento.getTitulo())
.setParameter(5, evento.getDescripcion())
.setParameter(6, evento.getDepartamento())
.setParameter(7, evento.getAdjuntos())
.setParameter(8, evento.getCompletado())
.setParameter(9, evento.getParticipantes())
.setParameter(10, evento.getTipoAlerta())
.executeUpdate();
*/
    }
}
