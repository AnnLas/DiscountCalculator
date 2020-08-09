package com.company.annlas;

import com.company.annlas.model.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double discount = getDiscount(reader);
        ShoppingCart shoppingCart = new ShoppingCart();
        addProductsToCart(reader, shoppingCart);
        shoppingCart.countDiscount(discount);
        System.out.println(shoppingCart);

    }

    private static void addSingleProductToCart(String userData, ShoppingCart shoppingCart) {
        double productPrice = 0;
        if (userData.contains(",")) {
            String[] productData = userData.split(",");
            try {
                productPrice = Double.parseDouble(productData[1]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                System.out.println("Product price has been set to 0");

            }
            shoppingCart.addProduct(new Product(productData[0], productPrice));
        } else {
            System.out.println("The enetered product was incorrect");
        }

    }

    private static double getDiscount(BufferedReader reader) {
        System.out.println("Hello, provide the amount of discount");
        try {
            return Double.parseDouble(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
            System.out.println("Discount has been set to 0");
            return 0;
        }
    }


    private static void addProductsToCart(BufferedReader reader, ShoppingCart shoppingCart) {
        LinkedList<String> products = new LinkedList<>();

        try {

            for (int i = 0; i < 5; i++) {
                System.out.printf("Provide product nr %d in format 'productName, price' or skip with enter", i + 1);
                System.out.println();
                addSingleProductToCart(reader.readLine(), shoppingCart);

            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
