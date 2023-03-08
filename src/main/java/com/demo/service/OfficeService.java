package com.demo.service;

import com.demo.dao.OfficeDao;
import com.demo.model.Office;
import com.mysql.cj.xdevapi.JsonString;

import javax.persistence.EntityManager;
import java.util.Optional;
import java.util.Scanner;

public class OfficeService {

    private OfficeDao officeDao;
    private final Scanner scanner = new Scanner(System.in);

    public OfficeService(EntityManager entityManager) {
        officeDao = new OfficeDao(entityManager);
        System.out.println("1-All Offices\n2-Get office by id");
        int option = scanner.nextInt();
        delegateTo(option);
    }

    private void delegateTo(int option) {
        switch (option) {
            case 1:
                getAll();
                break;
            case 2:
                System.out.print("Type office code: ");
                String id = scanner.next();
                getOfficeById(id);
                break;
        }
    }

    private void getOfficeById(String id) {
        Optional<Office> byId = officeDao.getById(id);
        Office office = byId.orElseThrow();
        System.out.println(office);
    }

    private void getAll() {
        officeDao.getOffices().forEach(System.out::println);
    }

}
