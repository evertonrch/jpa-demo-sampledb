package com.demo.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SalesReportDto {

    private String productName;
    private LocalDate orderDate;
    private Integer quantity;
    private String status;
    private BigDecimal buyPrice;

    public SalesReportDto(String productName, LocalDate orderDate, Integer quantity, String status, BigDecimal buyPrice) {
        this.productName = productName;
        this.orderDate = orderDate;
        this.quantity = quantity;
        this.status = status;
        this.buyPrice = buyPrice;
    }

    public String getProductName() {
        return productName;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getStatus() {
        return status;
    }

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    @Override
    public String toString() {
        return "SalesReportDto{" +
                "productName='" + productName + '\'' +
                ", orderDate=" + orderDate +
                ", quantity=" + quantity +
                ", status='" + status + '\'' +
                ", buyPrice=" + buyPrice +
                '}';
    }
}
