package com.project.Booking.Services;

import com.project.Booking.DTOs.BookDTO;

import java.util.List;

public interface BookService {

    BookDTO creatBook(Long authorId, BookDTO bookDTO);
    List<BookDTO> getAllBooksByAuthorId(Long authorId);
    BookDTO getBookByAuthorId(Long authorId, Long bookId);
    BookDTO updateBook(Long authorId, Long bookId,  BookDTO bookDTO);
    void deleteBook(Long authorId, Long bookId);

}
