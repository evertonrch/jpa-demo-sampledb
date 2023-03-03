package com.demo.service;

import com.demo.dao.EmployeeDao;
import com.demo.model.Employee;

import javax.persistence.EntityManager;
import java.util.Optional;
import java.util.Scanner;

public class EmployeeService {

    private final EmployeeDao employeeDao;
    private final Scanner scanner = new Scanner(System.in);
    public EmployeeService(EntityManager entityManager) {
        this.employeeDao = new EmployeeDao(entityManager);
        System.out.println("1-All employees\n2-Update employee\n3-Get employee job title by name");
        int option = scanner.nextInt();
        delegateTo(option);
    }

    private void delegateTo(int option) {
        switch (option) {
            case 1:
                getAll();
                break;
            case 2:
                System.out.print("Find a employee by id: ");
                Short id = scanner.nextShort();
                Employee employee = findById(id);
                System.out.println(employee);
                updateName(employee);
                break;
            case 3:
                System.out.print("Type employee name: ");
                String name = scanner.next();
                getEmployeJobTitleByName(name);
                break;
        }
    }

    private void getEmployeJobTitleByName(String name) {
        name = employeeDao.findEmployeeJobTitleByFirstName(name);
        System.out.println(name);
    }

    private void updateName(Employee employee) {
        System.out.print("Type a new name: ");
        String newName = scanner.next();
        newName = capitalize(newName);
        employeeDao.updateEmployee(employee, newName);
    }

    private String capitalize(String newName) {
        if(Character.isLowerCase(newName.charAt(0))) {
            return String.valueOf(newName.charAt(0))
                    .toUpperCase()
                    .concat(newName.substring(1));
        }
        return newName;
    }

    private Employee findById(Short id) {
        Optional<Employee> employee = employeeDao.findEmployee(id);
        return employee.orElse(null);
    }

    private void getAll() {
        employeeDao.getEmployees().forEach(System.out::println);
    }
}
