package com.bookstore.api.util;

import com.bookstore.api.dto.BaseDTO;
import com.bookstore.api.dto.BookDTO;
import com.bookstore.api.exception.InvalidDTOException;
import com.bookstore.api.exception.InvalidEntityException;
import com.bookstore.api.model.BaseEntity;
import com.bookstore.api.model.BookEntity;
import org.springframework.context.annotation.Bean;

public class EntityDTOConverter {
    public static BaseEntity convertToEntity(BaseDTO baseDTO) throws InvalidDTOException {
        if (baseDTO instanceof BookDTO bookDTO) {
            return new BookEntity(bookDTO.id(), bookDTO.title(), bookDTO.author(), bookDTO.publicationYear(), bookDTO.isbn(), bookDTO.price());
        } else {
            throw new InvalidDTOException("Cannot convert to entity.  Invalid DTO");
        }
    }

    public static BaseDTO convertToDTO(BaseEntity baseEntity) throws InvalidEntityException {
        if (baseEntity instanceof BookEntity bookEntity) {
            return new BookDTO(bookEntity.getId(), bookEntity.getTitle(), bookEntity.getAuthor(), bookEntity.getPublicationYear(), bookEntity.getIsbn(), bookEntity.getPrice());
        } else {
            throw new InvalidEntityException("Cannot convert to DTO.  Invalid Entity");
        }
    }
}
