package com.company.annlas;

import com.company.annlas.exceptions.IllegalDiscountArgumentException;
import com.company.annlas.model.CartProduct;
import com.company.annlas.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> productList;
    private List<CartProduct> discountedProductsList;
    private double cartSum;

    public ShoppingCart() {
        productList = new ArrayList<>();
        discountedProductsList = new ArrayList<>();
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public void addProduct(Product product) {
        productList.add(product);

    }

    public void countDiscount(double discount) {
        if (discount < 0) {
            throw new IllegalDiscountArgumentException("Discount cannot be negative!");
        }

        cartSum = countCartSum();

        if (cartSum < discount) {
            productList.forEach(product -> discountedProductsList.add(new CartProduct(product, product.getPrice())));
        } else {
            productList
                    .stream()
                    .limit(productList.size() - 1)
                    .forEach(product -> discountedProductsList.add(new CartProduct(product, calculateSingleProductDiscount(product.getPrice(), discount))));
            discountedProductsList.add(new CartProduct(productList.get(productList.size() - 1), Math.round((discount - countCartDiscount()) * 100) / 100.0));
        }
    }

    private double countCartSum() {
        return productList.stream().mapToDouble(Product::getPrice).sum();
    }

    private double countCartDiscount() {
        return discountedProductsList.stream().mapToDouble(CartProduct::getDiscount).sum();
    }

    public double calculateSingleProductDiscount(double productPrice, double discount) {
        return  ((int) ((discount * (productPrice / cartSum)) * 100))/100.0;
    }

    public List<CartProduct> getDiscountedProductsList() {
        return discountedProductsList;
    }
}
