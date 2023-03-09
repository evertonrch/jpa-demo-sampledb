package com.demo.service;

import com.demo.dao.OrderDao;
import com.demo.model.Order;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class OrderService {

    private OrderDao orderDao;
    private final Scanner scanner = new Scanner(System.in);

    public OrderService(EntityManager entityManager) {
        this.orderDao = new OrderDao(entityManager);
        System.out.println("1-All orders\n2-Order by status\n3-Order by status with comments\n4-Report");
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
            case 3:
                System.out.print("Type the status: ");
                status = scanner.next();
                getOrderByStatusWithComments(status);
                break;
            case 4:
                salesReport();
                break;
        }
    }
    private void salesReport() {
        List<Object[]> objects = orderDao.salesReport();
        for (Object[] object : objects) {
            String out = Arrays.toString(object);
            System.out.println(out);
        }
    }

    private void getOrderByStatusWithComments(String status) {
        orderDao.getTotalOrdersByStatusCommentsNonNull(status)
                .forEach(System.out::println);
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
