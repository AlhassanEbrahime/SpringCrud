package com.project.Booking.Services;

import com.project.Booking.DTOs.BookDTO;

import java.util.List;

public interface BookService {

    List<BookDTO> getAllBooks();
    BookDTO creatBook(BookDTO bookDTO);
    BookDTO getBookById(Long id);
    BookDTO updateBook(Long id, BookDTO bookDTO);
    void deleteBook(Long id);

}
