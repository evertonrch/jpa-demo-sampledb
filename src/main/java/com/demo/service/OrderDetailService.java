package com.demo.service;

import com.demo.dao.OrderDetailDao;
import com.demo.model.OrderDetail;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class OrderDetailService {
    private OrderDetailDao orderDetailDao;

    private final Scanner scanner = new Scanner(System.in);
    public OrderDetailService(EntityManager entityManager) {
        orderDetailDao = new OrderDetailDao(entityManager);
        System.out.println("1-All");
        int option = scanner.nextInt();
        delegateTo(option);
    }

    private void delegateTo(int option) {
        switch (option) {
            case 1:
                getAll();
                break;
        }
    }
    public void getAll() {
        orderDetailDao.getOrderDetails().forEach(System.out::println);
    }
}
