package com.kata.katabackend.exceptions;

public class NumberNotInRangeException extends RuntimeException {

    public NumberNotInRangeException(String message) {
        super(message);
    }
}