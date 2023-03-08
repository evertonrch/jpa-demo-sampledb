package com.demo.dao;

import com.demo.model.OrderDetail;

import javax.persistence.EntityManager;
import java.util.List;

public class OrderDetailDao {

    private EntityManager entityManager;

    public OrderDetailDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<OrderDetail> getOrderDetails() {
        return entityManager.createQuery("SELECT o FROM OrderDetail AS o", OrderDetail.class)
                .getResultList();
    }
}
