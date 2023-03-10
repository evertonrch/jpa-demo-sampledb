package com.demo.dao;

import com.demo.model.Employee;

import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class EmployeeDao {

    private EntityManager entityManager;

    public EmployeeDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Collection<Employee> getEmployees() {
        return entityManager.createQuery("SELECT e FROM Employee AS e", Employee.class)
                .getResultList();
    }

    public Optional<Employee> findEmployee(Short id) {
        return Optional.ofNullable(entityManager.find(Employee.class, id));
    }

    /*
     *  Instruções DML precisam estar em um contexto
     *  de transação.
     */
    public void updateEmployee(Employee employee, String name) {
        entityManager.getTransaction().begin();
        employee.setFirstName(name);
        entityManager.getTransaction().commit();
    }

    public String findEmployeeJobTitleByFirstName(String name) {
        return entityManager.createQuery("SELECT e.jobTitle FROM Employee AS e WHERE e.firstName = :nameParam", String.class)
                .setParameter("nameParam", name)
                .getSingleResult();
    }

    public List<Employee> getEmployeesByOffice(String country) {
        return entityManager.createQuery("SELECT e FROM Employee AS e WHERE e.office.country = :office", Employee.class)
                .setParameter("office", country)
                .getResultList();
    }
}
