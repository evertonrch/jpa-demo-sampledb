package com.demo.dao;

import com.demo.model.Product;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ProductDao {

    private EntityManager entityManager;

    public ProductDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public List<Product> productByPriceGreaterTha100(BigDecimal price) {
        return entityManager.createQuery("SELECT p FROM Product p WHERE p.buyPrice >= :price", Product.class)
                .setParameter("price", price)
                .getResultList();
    }

    public BigDecimal expensiveProcuct() {
        return entityManager.createQuery("SELECT MAX(p.buyPrice) FROM Product p", BigDecimal.class)
                .getSingleResult();
    }
}
