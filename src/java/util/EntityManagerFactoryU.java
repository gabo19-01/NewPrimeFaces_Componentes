package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

class EntityManagerFactoryUtil {

    private final EntityManagerFactory entityManagerFactory;
    private static EntityManagerFactoryUtil entityManagerFactoryUtil = null;

    private EntityManagerFactoryUtil(String persistenceUnitNombre) {
        this.entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitNombre);
    }

    private EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public static EntityManagerFactory getEntityManagerFactory(String persistenceUnitNombre){
        if (entityManagerFactoryUtil == null) {
            entityManagerFactoryUtil = new EntityManagerFactoryUtil(persistenceUnitNombre);
        }
        return entityManagerFactoryUtil.getEntityManagerFactory();
    }

}
