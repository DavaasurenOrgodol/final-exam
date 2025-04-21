package com.example.test.demo.exception.astronaut;

public class DuplicateAstronautException extends RuntimeException {
    public DuplicateAstronautException(String message) {
        super(message);
    }
}
