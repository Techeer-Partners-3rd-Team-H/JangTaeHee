package com.kancth03.techeerpartnersbackend.global.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    protected ResponseEntity<?> handleNoSuchElementFoundException(IllegalArgumentException e) {
        final ErrorResponse errorResponse = ErrorResponse.builder(
                new IllegalArgumentException(),
                HttpStatus.BAD_REQUEST,
                "잘못된 요청입니다."
                ).build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
