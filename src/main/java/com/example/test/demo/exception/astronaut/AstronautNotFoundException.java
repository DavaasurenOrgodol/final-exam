package com.example.test.demo.exception.astronaut;

public class AstronautNotFoundException extends RuntimeException {
    public AstronautNotFoundException(String message) {
        super(message);
    }
}
