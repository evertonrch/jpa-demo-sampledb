package com.demo.model.composedKey;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class OrderDetailId implements Serializable {

    private Integer orderNumber;
    private String productCode;

    @Override
    public String toString() {
        return "OrderDetailId{" +
                "orderNumber=" + orderNumber +
                ", productCode='" + productCode + '\'' +
                '}';
    }
}
