package com.demo.dao;

import com.demo.model.Order;

import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OrderDao {

    private EntityManager entityManager;

    public OrderDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Collection<Order> getOrders() {
        return entityManager.createQuery("SELECT o FROM Order AS o", Order.class)
                .getResultList();
    }

    public Map<String, List<Order>> getOrdersByStatus() {
        return entityManager.createQuery("SELECT o FROM Order AS o", Order.class)
                .getResultStream()
                .collect(Collectors.groupingBy(Order::getStatus));
    }
}
