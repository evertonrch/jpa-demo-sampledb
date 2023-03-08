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

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", priceEach=" + priceEach +
                ", order=" + order.getId() +
                ", product=" + product.getProductName() +
                '}';
    }
}
