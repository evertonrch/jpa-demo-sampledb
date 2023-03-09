package com.demo.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String productCode;
    private String productName;
    private String productScale;
    private String productVendor;
    @Lob
    private String productDescription;
    private Short quantityInStock;
    @Column(precision = 10, scale = 2)
    private BigDecimal buyPrice;
    @Column(precision = 10, scale = 2, name = "MSRP")
    private BigDecimal msrp;

    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails = new ArrayList<>();

    public String getProductCode() {
        return productCode;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public Short getQuantityInStock() {
        return quantityInStock;
    }

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

}
