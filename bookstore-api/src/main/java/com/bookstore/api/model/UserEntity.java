package com.bookstore.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Username is required")
    @Column(unique = true, nullable = false)
    private String username;

    private String password;

    private String role;

}
