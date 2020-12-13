/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import static Servicios.LoginServicio.startEntityManagerFactory;
import static Servicios.LoginServicio.stopEntityManagerFactory;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.*;
import componentes.Producto;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author carlossimpsonglaston
 */
public class ProductoServicio {
    
    private List<Producto> productos;

    private static EntityManagerFactory entityManagerFactory = null;
    private static EntityManager em = null;

    public ProductoServicio() {
    }
    
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
    
    public List<Producto> allProductos() {
        startEntityManagerFactory();
        TypedQuery<Producto> query;
        query = em.createQuery("SELECT p FROM Producto p", Producto.class);
        List<Producto> productos = query.getResultList();
        stopEntityManagerFactory();
        return productos;
    }
}
