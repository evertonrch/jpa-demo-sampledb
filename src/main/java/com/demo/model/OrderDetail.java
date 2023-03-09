package com.demo.model;

import com.demo.model.composedKey.OrderDetailId;

import javax.persistence.*;
import java.math.BigDecimal;
@Entity
@Table(name = "orderdetails")
public class OrderDetail {
    @EmbeddedId
    private OrderDetailId id;
    @Column(name = "quantityOrdered")
    private Integer quantity;
    private BigDecimal priceEach;
    private Short orderLineNumber;

    @ManyToOne
    @JoinColumn(name = "orderNumber", insertable = false, updatable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "productCode", insertable = false, updatable = false)
    private Product product;

    public OrderDetailId getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public BigDecimal getPriceEach() {
        return priceEach;
    }

    public Short getOrderLineNumber() {
        return orderLineNumber;
    }

    public Order getOrder() {
        return order;
    }

    public Product getProduct() {
        return product;
    }
}
