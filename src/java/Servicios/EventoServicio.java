/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import correo.Usuario;
import correo.Evento;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author mike
 * Clase que permite accesar a los EVENTOS en la base de datos. 
 */

public class EventoServicio {
    
    private static EntityManagerFactory entityManagerFactory = null;
    private static EntityManager em = null;
    
    
    
    public EventoServicio(){
    }
        
    // Metodo que se encarga de crear la entidad.
    public static void startEntityManagerFactory() {
        if (entityManagerFactory == null) {
            try {
                entityManagerFactory = Persistence.createEntityManagerFactory("EmailComponente");
                em = entityManagerFactory.createEntityManager();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // Metodo que se encarga de detener el entity manager
    public static void stopEntityManagerFactory() {
        if (entityManagerFactory != null) {
            if (entityManagerFactory.isOpen()) {
                try {
                    entityManagerFactory.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            em.close();
            entityManagerFactory = null; 
        }
    }
    
    
    /*
    Metodo que se encarga de conseguir todos los eventos asociados al usuario que se le envie como parametro
    input-> creador:Usuario
    output-> eventos:List<Evento> 
    */
    public List<Evento> getEventosUsuario(Usuario creador){
        Long creadorID = creador.getIdUsuario();
        
        startEntityManagerFactory();
        TypedQuery<Evento> query;
        query = em.createQuery("SELECT e FROM Evento e WHERE creador = " + creadorID + ";", Evento.class);
        List<Evento> eventos =  query.getResultList();
        stopEntityManagerFactory();
        return eventos;
    }
    
    
}//ENDOFLCASS
