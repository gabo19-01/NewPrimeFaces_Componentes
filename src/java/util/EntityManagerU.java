package util;

import javax.persistence.EntityManager;

public class EntityManagerU {

    public static EntityManager getEntityManager(String persistenceUnitNombre){
        return EntityManagerFactoryUtil.
                getEntityManagerFactory(persistenceUnitNombre).
                createEntityManager();
    }
}
