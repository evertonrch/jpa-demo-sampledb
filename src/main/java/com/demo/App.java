package com.demo;


import com.demo.config.JPAConfig;
import com.demo.dao.CustomerDao;
import com.demo.dao.OrderDao;
import com.demo.model.Order;
import com.demo.service.*;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {

    private static boolean state = true;
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        EntityManager entityManager = JPAConfig.getEntityManager();

        while (state) {
            System.out.println("0-Quit\n1-Employees\n2-Customers\n3-Orders\n4-Offices\n5-OrderDetails\n6-Products");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    new EmployeeService(entityManager);
                    break;
                case 2:
                    customers(entityManager);
                    break;
                case 3:
                    new OrderService(entityManager);
                    break;
                case 4:
                    new OfficeService(entityManager);
                    break;
                case 5:
                    new OrderDetailService(entityManager);
                case 6:
                    new ProductService(entityManager);
                    break;
                case 0:
                default:
                    state = false;
                    System.out.println("Bye!");
                    break;
            }
        }
        JPAConfig.closeResources();
    }

    private static void order(EntityManager entityManager) {
        OrderDao orderDao = new OrderDao(entityManager);
        System.out.println("1-All orders\n2-Orders by status");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                orderDao.getOrders().forEach(System.out::println);
                break;
            case 2:
                Map<String, List<Order>> ordersByStatus = orderDao.getTotalOrdersByStatus();
                ordersByStatus.forEach((status, orders) -> {
                    System.out.printf("%s, %d%n", status, orders.size());;
                });
                break;
        }

    }
    private static void customers(EntityManager entityManager) {
        CustomerDao customersDao = new CustomerDao(entityManager);
        customersDao.getCustomers().forEach(System.out::println);
    }
}
