package com.company.annlas;

public class Main {

    public static void main(String[] args) {
        double discount = 105;
        double productPrice = 1500;
        double cartSum = 2000;
        double part = ((int) ((discount * (productPrice / cartSum)) * 100))/100.0;
        System.out.println(part);
        System.out.println(part / 100.0);

    }
}
