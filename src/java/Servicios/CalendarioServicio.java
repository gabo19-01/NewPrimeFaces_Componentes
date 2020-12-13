/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import componentes.Alerta;
import componentes.Evento;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import componentes.Usuario;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *Clase que permite accesar a todos lo eventos del calendario
 * @author gabri
 */


public class CalendarioServicio {
    
    private static EntityManagerFactory entityManagerFactory = null;
    private static EntityManager em = null;



    // Metodo que se encarga de crear la entidad.
    public static void startEntityManagerFactory() {
        if (entityManagerFactory == null) {
            try {
                entityManagerFactory = Persistence.createEntityManagerFactory("componentecorreos");
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
    
    /*
    Metodo que se encarga de conseguir todos los eventos asociados al usuario que se le envie como parametro
    input -> creadro:Usuario
    output -> eventos:List<Evento>
    */
    public List<Evento> getEventosUsuario(Usuario creador){
        int creadorId = creador.getUsuarioID();
        
        startEntityManagerFactory();
        TypedQuery<Evento> query;
        query = em.createQuery("SELECT e FORM Evento e WHERE creador = " + creadorId + ";", Evento.class);
        List<Evento> eventos = query.getResultList();
        stopEntityManagerFactory();
        return eventos;        
    }    
    
}//endofclass
