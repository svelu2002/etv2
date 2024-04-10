package com.bookstore.api.exception;

public class InvalidDTOException extends IllegalArgumentException {
    public InvalidDTOException(String message) {
        super(message);
    }
}
