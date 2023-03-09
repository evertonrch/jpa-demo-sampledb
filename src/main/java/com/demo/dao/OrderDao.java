package com.demo.dao;

import com.demo.dto.SalesReportDto;
import com.demo.model.Order;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderDao {

    private EntityManager entityManager;

    public OrderDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Collection<Order> getOrders() {
        return entityManager.createQuery("SELECT o FROM Order AS o", Order.class)
                .getResultList();
    }

    public Map<String, List<Order>> getTotalOrdersByStatus() {
        return entityManager.createQuery("SELECT o FROM Order AS o", Order.class)
                .getResultStream()
                .collect(Collectors.groupingBy(Order::getStatus));
    }

    public List<Order> findByStatus(String status) {
        return entityManager.createQuery("SELECT o FROM Order AS o WHERE o.status = :status", Order.class)
                .setParameter("status", status)
                .getResultList();
    }

    public List<Order> getTotalOrdersByStatusCommentsNonNull(String status) {
        return entityManager.createQuery("SELECT o FROM Order AS o WHERE o.status = :status AND o.comments != null", Order.class)
                .setParameter("status", status)
                .getResultList();

    }

    public List<SalesReportDto> salesReport() {
        String jpql = "SELECT new com.demo.dto.SalesReportDto(prod.productName, o.orderDate, "
                    +" detail.quantity, o.status, prod.buyPrice) "
                    +" FROM Order o INNER JOIN o.orderDetails detail "
                    +" INNER JOIN detail.product prod ";

        return entityManager.createQuery(jpql, SalesReportDto.class)
                .getResultList();
    }
}
