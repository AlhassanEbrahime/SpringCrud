package com.project.Booking.Services.serviceimples;

import com.project.Booking.DTOs.BookDTO;
import com.project.Booking.Entites.Book;
import com.project.Booking.Exceptions.BookNotFoundException;
import com.project.Booking.Mappers.MapperInterfaces.BookMapper;
import com.project.Booking.Repositories.BookRepository;
import com.project.Booking.Services.serviceinterfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    private BookMapper bookMapper;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper){
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(bookMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public BookDTO creatBook(BookDTO bookDTO) {
        Book book = bookMapper.toEntity(bookDTO);
        Book savedBook = bookRepository.save(book);
        return bookMapper.toDto(savedBook);

    }

    @Override
    public BookDTO getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(()-> new BookNotFoundException("Book not found with id "+ id));
        return bookMapper.toDto(book);
    }

    @Override
    public BookDTO updateBook(Long id, BookDTO bookDTO) {
        Book existingBook = bookRepository.findById(id).
                orElseThrow(()-> new BookNotFoundException("Book not found with id "+ id));

        existingBook.setTitle(bookDTO.getTitle());
        existingBook.setAuthor(bookDTO.getAuthor());
        existingBook.setPublishedDate(bookDTO.getPublishedDate());

        Book updatedBook = bookRepository.save(existingBook);
        return bookMapper.toDto(updatedBook);
    }

    @Override
    public void deleteBook(Long id) {
       if(!bookRepository.existsById(id)){
           throw new BookNotFoundException("Book not found with id "+ id);
       }
       bookRepository.deleteById(id);
    }


}
