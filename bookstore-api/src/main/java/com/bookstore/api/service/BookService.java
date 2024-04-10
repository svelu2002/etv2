package com.bookstore.api.service;

import com.bookstore.api.dto.BaseDTO;
import com.bookstore.api.dto.BookDTO;
import com.bookstore.api.exception.InvalidDTOException;
import com.bookstore.api.exception.InvalidEntityException;

import java.util.List;

public interface BookService {
    public BookDTO saveBook(BookDTO bookDTO) throws InvalidEntityException, InvalidDTOException;

    public List<BookDTO> getAllBooks() throws InvalidEntityException;

    public BookDTO updateBook(long id, BookDTO bookDTO) throws InvalidEntityException, InvalidDTOException;;

    public BookDTO getBookById(long id);

    public void deleteBook(long id);

}
