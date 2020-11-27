/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Modelo.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author gabri
 */
public class LoginServicio {

    public List<Usuario> allUsuarios() {
        TypedQuery<Usuario> query;
        query = EntityManager.createQuery("SELECT u FROM Usuario u", Usuario.class);
        List<Usuario> results = query.getResultList();
        return results;

    }
}
