package com.myapp.userapp.exceptionhandlers;

import com.myapp.userapp.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;
import java.time.LocalTime;

@RestControllerAdvice
public class UserApiErrorHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value=UserNotFoundException.class)
    public ProblemDetail handleUserNotFoundException(UserNotFoundException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        problemDetail.setDetail(e.getMessage());
        problemDetail.setProperty("timestamp", LocalTime.now());
        problemDetail.setTitle(e.getClass().getSimpleName());
        return problemDetail;
    }
}
