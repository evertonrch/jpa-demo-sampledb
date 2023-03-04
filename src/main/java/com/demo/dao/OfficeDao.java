package com.demo.dao;

import com.demo.model.Office;

import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.Optional;

public class OfficeDao {

    private final EntityManager entityManager;

    public OfficeDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Collection<Office> getOffices() {
        return entityManager.createQuery("SELECT o FROM Office o", Office.class)
                .getResultList();
    }

    public Optional<Office> getById(String id) {
        return Optional.ofNullable(entityManager.find(Office.class, id));
    }

}
