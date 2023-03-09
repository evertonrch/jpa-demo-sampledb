package com.demo.service;

import com.demo.dao.OrderDetailDao;

import javax.persistence.EntityManager;
import java.util.Formatter;
import java.util.Locale;
import java.util.Scanner;

public class OrderDetailService {
    private final OrderDetailDao orderDetailDao;
    private final Formatter formatter = new Formatter(Locale.getDefault());
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
       orderDetailDao.getOrderDetails().forEach(orderDetail -> {
           formatter.format("id: %s, productName: %s, orderStatus: %s, price: %.2f, quantity: %d%n",
                   orderDetail.getId(), orderDetail.getProduct().getProductName(),
                   orderDetail.getOrder().getStatus(),orderDetail.getPriceEach(),
                   orderDetail.getQuantity());

           System.out.println(formatter);
       });
    }
}
