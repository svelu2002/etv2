package com.bookstore.api.controller;

import com.bookstore.api.dto.BookDTO;
import com.bookstore.api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<BookDTO> saveBook(@RequestBody BookDTO bookDTO) {
        BookDTO newBook = bookService.saveBook(bookDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newBook);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        List<BookDTO> books = bookService.getAllBooks();
        return ResponseEntity.status(HttpStatus.OK).body(books);
    }



}
