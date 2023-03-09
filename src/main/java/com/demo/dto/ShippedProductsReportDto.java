package com.demo.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ShippedProductsReportDto {

    private String productName;
    private String status;
    private LocalDate orderDate;
    private LocalDate shippedDate;
    private int diffDays;
    private BigDecimal totalPrice;

    public ShippedProductsReportDto(String productName, String status, LocalDate orderDate, LocalDate shippedDate, int diffDays, BigDecimal totalPrice) {
        this.productName = productName;
        this.status = status;
        this.orderDate = orderDate;
        this.shippedDate = shippedDate;
        this.diffDays = diffDays;
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "ShippedProductsReportDto{" +
                "productName='" + productName + '\'' +
                ", status='" + status + '\'' +
                ", orderDate=" + orderDate +
                ", shippedDate=" + shippedDate +
                ", diffDays=" + diffDays +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
