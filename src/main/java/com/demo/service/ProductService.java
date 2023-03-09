package com.demo.service;

import com.demo.dao.ProductDao;
import com.demo.model.Product;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.text.Normalizer;
import java.util.Scanner;

public class ProductService {

    private final ProductDao productDao;

    private final Scanner scanner = new Scanner(System.in);
    public ProductService(EntityManager entityManager) {
        this.productDao = new ProductDao(entityManager);

        System.out.println("1-All products\n2-Products by pric\n3-More expensive product");
        int option = scanner.nextInt();
        delegateTo(option);
    }

    private void delegateTo(int option) {
        switch (option) {
            case 1:
            case 2:
                System.out.print("Type price: ");
                BigDecimal price = scanner.nextBigDecimal();
                byPrice(price);
            case 3:
                moreExpensiv();
                break;
        }
    }

    private void moreExpensiv() {
        String out = String.format("Your price: %.2f", productDao.expensiveProcuct());
        System.out.println(out);
    }

    private void byPrice(BigDecimal price) {
        productDao.productByPriceGreaterTha100(price).forEach(product -> {
            String formatted = String.format("Product: %s, price: %.2f", product.getProductName(), product.getBuyPrice());
            System.out.println(formatted);
        });
    }
}
