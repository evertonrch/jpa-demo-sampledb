package com.demo.service;

import com.demo.dao.OrderDao;
import com.demo.dto.SalesReportDto;
import com.demo.dto.ShippedProductsReportDto;
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
        System.out.println("1-All orders\n2-Order by status\n3-Order by status with comments\n4-Report\n5-Shipped products report");
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
            case 5:
                shippedProductsReport();
                break;
        }
    }

    private void shippedProductsReport() {
        List<ShippedProductsReportDto> shippedProducts = orderDao.shippedProductsReport();
        shippedProducts.stream()
                .sorted(Comparator.comparing(ShippedProductsReportDto::getTotalPrice))
                .forEach(System.out::println);
    }

    private void salesReport() {
        List<SalesReportDto> salesReport = orderDao.salesReport();
        salesReport.forEach(System.out::println);
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
