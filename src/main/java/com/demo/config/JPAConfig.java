package com.demo.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAConfig {
    private final static EntityManagerFactory factory = Persistence
            .createEntityManagerFactory("mysql-example");

    public static EntityManager getEntityManager() {
       return factory.createEntityManager();
    }

    public static void closeResources() {
        if(factory != null)
            factory.close();
    }
}
