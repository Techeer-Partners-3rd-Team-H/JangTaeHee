package com.kancth03.techeerpartnersbackend.global.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    // Controller하나 만들어서 분리해주는것도 괜찮을꺼같기도한데..
    @ExceptionHandler(IllegalArgumentException.class)
    protected ResponseEntity<ErrorResponse> illegalArgumentException(IllegalArgumentException e) {
        final ErrorResponse errorResponse = ErrorResponse.builder(
                new IllegalArgumentException(),
                HttpStatus.BAD_REQUEST,
                e.getMessage())
                .detailMessageArguments("이미 사용중인 레스토랑명입니다.")
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
