/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;
import componentes.Bitacora;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import util.EntityManagerU;
/**
 *
 * @author 6fantasticos
 */
public class BitacoraDAO<Bitacora> implements IDAO {
    
    private final EntityManager em;

    public BitacoraDAO() {
        this.em = EntityManagerU.getEntityManager("EmailComponente");
    }
    
    @Override
    public List<Bitacora> getAll() {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.clear();
         List<Bitacora> list = em.createQuery("select u from Bitacora u").getResultList();
        transaction.commit();
        return list;
    }

    @Override
    public Object getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object createOrUpdate(Object entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object deleteById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
