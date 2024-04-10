package com.bookstore.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "books")
public class BookEntity implements BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Title is required")
    @Column(unique = true, nullable = false)
    private String title;

    @NotBlank(message = "Author is required")
    @Column(nullable = false)
    private String author;

    @Column(name="publication_year", nullable = false)
    private int publicationYear;

    @Column(nullable = false)
    private long isbn;

    @Column(nullable = false)
    private double price;
}
