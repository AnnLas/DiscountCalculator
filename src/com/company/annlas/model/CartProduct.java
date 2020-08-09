package com.company.annlas.model;

public class CartProduct {
    private Product product;
    private double discount;
    private static final String PL_CURRENCY = "zł";

    public CartProduct(Product product, double discount) {
        this.product = product;
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public double getProductPrice() {
        return product.getPrice();
    }

    public Product getProduct() {
        return product;
    }


    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Discount for: " + product.getName() + " = " + discount + PL_CURRENCY;
    }
}
