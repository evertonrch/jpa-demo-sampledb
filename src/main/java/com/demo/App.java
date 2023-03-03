package com.demo;


import com.demo.config.JPAConfig;
import com.demo.dao.CustomersDao;
import com.demo.dao.EmployeeDao;
import com.demo.model.Employee;

import javax.persistence.EntityManager;
import javax.swing.*;
import java.util.Collection;
import java.util.Scanner;

public class App {

    private static boolean state = true;

    public static void main(String[] args) {
        EntityManager entityManager = JPAConfig.getEntityManager();

        while (state) {
            System.out.println("1-Employees\n2-Customers");
            int option = new Scanner(System.in).nextInt();
            switch (option) {
                case 1:
                    employees(entityManager);
                    break;
                case 2:
                    customers(entityManager);
                    break;
                default:
                    state = false;
                    break;
            }
        }
        JPAConfig.closeResources();
    }
    private static void customers(EntityManager entityManager) {
        CustomersDao customersDao = new CustomersDao(entityManager);
        customersDao.getCustomers().forEach(System.out::println);
    }

    private static void employees(EntityManager entityManager) {
        EmployeeDao employeeDao = new EmployeeDao(entityManager);
        employeeDao.getEmployees().forEach(System.out::println);
    }


}
