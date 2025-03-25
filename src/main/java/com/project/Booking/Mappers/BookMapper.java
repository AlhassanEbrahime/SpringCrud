package com.project.Booking.Mappers;

import com.project.Booking.DTOs.BookDTO;
import com.project.Booking.Entites.Book;

public interface BookMapper {
    BookDTO toDto(Book book);

    Book toEntity(BookDTO bookDTO);
}
