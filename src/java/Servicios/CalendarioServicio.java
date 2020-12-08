/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import correo.Alerta;
import correo.Evento;
;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

/**
 *
 * @author gabri
 */


public class CalendarioServicio {

    private static EntityManager em = null;
    
    @Transactional
    public int insertEvent(Evento evento){
        this.em.persist(evento);
        em.flush();
        return evento.getEventoID();
    }
    @Transactional
    public void insertAlerta(Alerta alerta){
        this.em.persist(alerta);
        em.flush(); 
    }
}
