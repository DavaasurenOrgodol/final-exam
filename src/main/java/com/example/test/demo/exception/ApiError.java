package com.example.test.demo.exception;

import java.time.Instant;
import java.util.List;

public record ApiError(
        String message,
        String path,
        Integer statusCode,
        Instant timeStamp,
        List<String> errors) {

}
