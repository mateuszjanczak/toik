package com.demo.springboot.exception;

public class EmptyDtoException extends Exception {
    public EmptyDtoException(String message) {
        super(message);
    }

    public EmptyDtoException() {

    }
}
