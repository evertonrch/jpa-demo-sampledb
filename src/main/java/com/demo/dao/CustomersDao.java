package com.demo.dao;

import javax.persistence.EntityManager;
import java.util.stream.Stream;

public class CustomersDao {
    private EntityManager entityManager;

    public CustomersDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Stream<Customer> getCustomers() {
        return entityManager.createQuery("SELECT c FROM Customer AS c", Customer.class)
                .getResultList().stream();
    }


}
