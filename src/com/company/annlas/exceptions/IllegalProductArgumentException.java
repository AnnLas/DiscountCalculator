package com.company.annlas.exceptions;


public class IllegalProductArgumentException extends IllegalArgumentException {
    public IllegalProductArgumentException(String errorMessage)
    {
        super(errorMessage);
    }
}
