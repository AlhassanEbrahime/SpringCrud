package com.project.Booking.Mappers.Impl;
import com.project.Booking.DTOs.BookDTO;
import com.project.Booking.Entites.Author;
import com.project.Booking.Entites.Book;
import com.project.Booking.Mappers.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookMapperImpl implements BookMapper {

    @Override
    public BookDTO toDto(Book book) {
        if(book == null){
            return null;
        }
        BookDTO bookDTO = new BookDTO();
        bookDTO.setTitle(book.getTitle());
        bookDTO.setPublishedDate(book.getPublishedDate());
        return bookDTO;
    }

    @Override
    public Book toEntity(BookDTO bookDTO, Author author) {
        if(bookDTO == null){
            return null;
        }
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setPublishedDate(bookDTO.getPublishedDate());
        book.setAuthor(author);
        return book;
    }
}
