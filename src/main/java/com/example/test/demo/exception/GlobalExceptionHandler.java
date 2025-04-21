package com.example.test.demo.exception;

import java.time.Instant;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.test.demo.exception.astronaut.AstronautNotFoundException;
import com.example.test.demo.exception.astronaut.DuplicateAstronautException;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

        @ExceptionHandler(DuplicateAstronautException.class)
        public ResponseEntity<ApiError> handleDuplicateUserException(DuplicateAstronautException e,
                        HttpServletRequest request) {
                ApiError apiError = new ApiError(
                                e.getMessage(),
                                request.getRequestURI(),
                                HttpStatus.BAD_REQUEST.value(),
                                Instant.now(),
                                List.of(e.getMessage()));
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
        }

        @ExceptionHandler(DataIntegrityViolationException.class)
        public ResponseEntity<ApiError> handleDataIntegrityViolationException(DataIntegrityViolationException e,
                        HttpServletRequest request) {
                ApiError apiError = new ApiError(
                                e.getMessage(),
                                request.getRequestURI(),
                                HttpStatus.CONFLICT.value(),
                                Instant.now(),
                                List.of(e.getMessage()));
                return ResponseEntity.status(HttpStatus.CONFLICT).body(apiError);
        }

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<ApiError> handleValidation(MethodArgumentNotValidException ex,
                        HttpServletRequest request) {
                List<String> errors = ex.getBindingResult().getFieldErrors()
                                .stream()
                                .map(e -> e.getField() + ": " + e.getDefaultMessage())
                                .toList();
                ApiError apiError = new ApiError(
                                "Validation failed",
                                request.getRequestURI(),
                                HttpStatus.CONFLICT.value(),
                                Instant.now(),
                                errors);

                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
        }

        @ExceptionHandler(AstronautNotFoundException.class)
        public ResponseEntity<ApiError> handleUserNotFoundException(AstronautNotFoundException e,
                        HttpServletRequest request) {
                ApiError apiError = new ApiError(
                                "Validation failed",
                                request.getRequestURI(),
                                HttpStatus.CONFLICT.value(),
                                Instant.now(),
                                List.of(e.getMessage()));

                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
        }
}
