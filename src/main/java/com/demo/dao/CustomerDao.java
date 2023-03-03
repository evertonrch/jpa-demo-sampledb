package com.demo.dao;

import com.demo.model.Customer;

import javax.persistence.EntityManager;
import java.util.stream.Stream;

public class CustomerDao {
    private EntityManager entityManager;

    public CustomerDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Stream<Customer> getCustomers() {
        return entityManager.createQuery("SELECT c FROM Customer AS c", Customer.class)
                .getResultStream();
    }


}
