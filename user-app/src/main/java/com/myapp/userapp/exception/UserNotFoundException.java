package com.myapp.userapp.exception;

import com.myapp.userapp.model.User;

public class UserNotFoundException extends RuntimeException {
    UserNotFoundException(String error) {
        super(error);
    }
}
