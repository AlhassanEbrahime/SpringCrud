package com.project.Booking.Mappers.MapperImpls;

import com.project.Booking.DTOs.BookDTO;
import com.project.Booking.Entites.Book;
import com.project.Booking.Mappers.MapperInterfaces.BookMapper;
import org.springframework.stereotype.Component;

@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public BookDTO toDto(Book book) {
        if(book == null){
            return null;
        }

        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setPublishedDate(book.getPublishedDate());
        return bookDTO;
    }

    @Override
    public Book toEntity(BookDTO bookDTO) {
        if(bookDTO == null){
            return null;
        }

        Book book = new Book();
        book.setId(bookDTO.getId());
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setPublishedDate(bookDTO.getPublishedDate());
        return book;
    }
}
