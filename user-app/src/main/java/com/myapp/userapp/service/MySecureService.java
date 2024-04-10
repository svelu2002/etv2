package com.myapp.userapp.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class MySecureService {
    public String getMessage() {
        return "Hello Everyone";
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public String getUserMessage() {
        return "Hello User";
    }

    @PreAuthorize("hasRole('ADMIN')")
    public String getAdminMessage() {
        return "Hello Admin";
    }
}
