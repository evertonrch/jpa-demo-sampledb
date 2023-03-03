package com.demo.dao;

import com.demo.model.Employee;

import javax.persistence.EntityManager;
import java.util.Collection;

public class EmployeeDao {

    private EntityManager entityManager;

    public EmployeeDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public Collection<Employee> getEmployees() {
        return entityManager.createQuery("SELECT e FROM Employee AS e", Employee.class)
                .getResultList();
    }
}
