package com.myapp.userapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record UserDTO(@NotNull int userId, @NotBlank String name, String email, LocalDate dob) {}
