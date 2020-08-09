package com.company.annlas.model;

import com.company.annlas.exceptions.IllegalProductArgumentException;

public class Product {
    private final String name;
    private final double price;

    public Product(String name, double price) {
        if (name == null || price<0){
            throw new IllegalProductArgumentException("Given product arguments are not valid!");

        }
        this.name = name;
        this.price = price;

    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}


