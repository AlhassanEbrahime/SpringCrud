package com.project.Booking.Mappers;

import com.project.Booking.DTOs.BookDTO;
import com.project.Booking.Entites.Author;
import com.project.Booking.Entites.Book;
import org.springframework.stereotype.Component;


public interface BookMapper {
    BookDTO toDto(Book book);

    Book toEntity(BookDTO bookDTO , Author author);
}
