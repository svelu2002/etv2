package com.bookstore.api.service;

import com.bookstore.api.dto.BaseDTO;
import com.bookstore.api.dto.BookDTO;
import com.bookstore.api.exception.InvalidDTOException;
import com.bookstore.api.exception.InvalidEntityException;
import com.bookstore.api.model.BookEntity;
import com.bookstore.api.repository.BookRepository;
import com.bookstore.api.util.EntityDTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    public static <T, R> Function<T, R> wrapCheckedException(CheckedFunction<T, R> function) {
        return arg -> {
            try {
                return function.apply(arg);
            } catch (InvalidEntityException e) {
                throw new RuntimeException(e);
            }
        };
    }

    @FunctionalInterface
    public interface CheckedFunction<T, R> {
        R apply(T t) throws InvalidEntityException;
    }

    @Override
    public BookDTO saveBook(BookDTO bookDTO) throws InvalidEntityException, InvalidDTOException {
        BookEntity bookEntity = bookRepository.save((BookEntity) EntityDTOConverter.convertToEntity(bookDTO));
        return (BookDTO) EntityDTOConverter.convertToDTO(bookEntity);
    }

    @Override
    public List<BookDTO> getAllBooks() {
        List<BookEntity> bookEntities = bookRepository.findAll();
        return bookEntities.stream()
                .map(bookEntity -> {
                    try {
                        return (BookDTO) EntityDTOConverter.convertToDTO(bookEntity);
                    } catch (InvalidEntityException ex) {
                        return null;
                    }
                })
                .toList();
    }

    @Override
    public BookDTO updateBook(long id, BookDTO bookDTO) {
        return null;
    }

    @Override
    public BookDTO getBookById(long id) {
        return null;
    }

    @Override
    public void deleteBook(long id) {

    }
}
