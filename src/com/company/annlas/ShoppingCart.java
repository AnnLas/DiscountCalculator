package com.company.annlas;

import com.company.annlas.exceptions.IllegalDiscountArgumentException;
import com.company.annlas.model.CartProduct;
import com.company.annlas.model.Product;


import java.util.LinkedList;
import java.util.List;

public class ShoppingCart {
    private List<CartProduct> discountedProductsList;
    private double cartSum;

    public ShoppingCart() {
        discountedProductsList = new LinkedList<>();
    }

    public void setProductList(List<Product> productList) {
        productList.forEach(product -> discountedProductsList.add(new CartProduct(product, 0)));
    }

    public void addProduct(Product product) {
        discountedProductsList.add(new CartProduct(product, 0));

    }

    public void countDiscount(double discount) {
        if (discount < 0) {
            throw new IllegalDiscountArgumentException("Discount cannot be negative!");
        }

        cartSum = countCartSum();

        if (cartSum < discount) {
            discountedProductsList.forEach(product -> product.setDiscount(product.getProductPrice()));
        } else {
            discountedProductsList
                    .stream()
                    .limit(discountedProductsList.size() - 1)
                    .forEach(product -> product.setDiscount(calculateSingleProductDiscount(product.getProductPrice(), discount)));
            discountedProductsList.get(discountedProductsList.size() - 1).setDiscount(Math.round((discount - countCartDiscount()) * 100) / 100.0);
        }
    }

    private double countCartSum() {
        return discountedProductsList.stream().mapToDouble(CartProduct::getProductPrice).sum();
    }

    private double countCartDiscount() {
        return discountedProductsList.stream().mapToDouble(CartProduct::getDiscount).sum();
    }

    private double calculateSingleProductDiscount(double productPrice, double discount) {
        return ((int) ((discount * (productPrice / cartSum)) * 100)) / 100.0;
    }

    public List<CartProduct> getDiscountedProductsList() {
        return discountedProductsList;
    }

    @Override
    public String toString() {
        return tableHeader() + tableBody(discountedProductsList);
    }

    private static String tableHeader() {
        return String.format("%30s %25s %10s %25s %10s", "Item", "|", "Price(zł)", "|", "Discount") + "\n" +
                String.format("%s", "----------------------------------------------------------------------------------------------------------------");
    }

    private static String tableBody(List<CartProduct> products) {
        StringBuilder tableBody = new StringBuilder();
        for (CartProduct product : products) {
            tableBody.append("\n").append(String.format("%30s %25s %10.2f %25s %10.2f", product.getProduct().getName(), "|", product.getProductPrice(), "|", product.getDiscount()));
        }
        return tableBody.toString();
    }
}
