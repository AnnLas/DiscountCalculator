package com.company.annlas.exceptions;

public class IllegalDiscountArgumentException extends IllegalArgumentException {
    public IllegalDiscountArgumentException (String errorMessage)
    {
        super(errorMessage);
    }
}
