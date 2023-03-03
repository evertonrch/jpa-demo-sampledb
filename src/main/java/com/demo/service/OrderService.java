package com.demo.service;

import com.demo.dao.OrderDao;
import com.demo.model.Order;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class OrderService {

    private OrderDao orderDao;
    private final Scanner scanner = new Scanner(System.in);
    public OrderService(EntityManager entityManager) {
        this.orderDao = new OrderDao(entityManager);
        System.out.println("1-All orders\n2-Order by status");
        int option = scanner.nextInt();
        delegateTo(option);
    }

    private void delegateTo(int option) {
        switch (option) {
            case 1:
                getAllOrders();
                break;
            case 2:
                System.out.print("Type the status: ");
                scanner.nextLine();
                String status = scanner.nextLine();
                getOrderByStatus(status);
                break;
        }
    }

    private void getOrderByStatus(String status) {
        List<Order> byStatus = orderDao.findByStatus(status);
        ListIterator<Order> listIterator = byStatus.listIterator();
        while (listIterator.hasNext())
            System.out.println(listIterator.next());
    }

    private void getAllOrders() {
        orderDao.getOrders().forEach(System.out::println);
    }
}
