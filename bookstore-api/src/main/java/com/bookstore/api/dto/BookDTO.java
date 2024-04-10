package com.bookstore.api.dto;

public record BookDTO(Long id, String title, String author, int publicationYear, long isbn, double price) implements BaseDTO {
}
