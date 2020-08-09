package com.company.annlas.model;

public class CartProduct {
    private Product product;
    private double discount;

    public CartProduct(Product product, double discount) {
        this.product = product;
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public Product getProduct() {
        return product;
    }
}
