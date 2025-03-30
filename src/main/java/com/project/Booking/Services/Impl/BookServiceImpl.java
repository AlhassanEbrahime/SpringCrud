package com.project.Booking.Services.Impl;

import com.project.Booking.DTOs.BookDTO;
import com.project.Booking.Entites.Author;
import com.project.Booking.Entites.Book;
import com.project.Booking.Exceptions.ResourceNotFoundException;
import com.project.Booking.Mappers.BookMapper;
import com.project.Booking.Repositories.AuthorRepository;
import com.project.Booking.Repositories.BookRepository;
import com.project.Booking.Services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookMapper bookMapper;
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;


    public Author getAuthor(Long authorId){
        return authorRepository.findById(authorId)
                .orElseThrow(()-> new ResourceNotFoundException("Author not found with id :"+ authorId));
    }

    public Book getBookForAuthor(Long authorId, Long bookId){
        return bookRepository.findById(bookId)
                .filter(book -> book.getAuthor().getId().equals(authorId))
                .orElseThrow(()-> new ResourceNotFoundException("Book not found with id: "+ bookId + " - for author with id: "+ authorId));
    }

    @Override
    public BookDTO creatBook(Long authorId, BookDTO bookDTO) {
        Author author = getAuthor(authorId);
        Book book = bookMapper.toEntity(bookDTO, author);
        Book savedBook = bookRepository.save(book);
        return bookMapper.toDto(savedBook);
    }

    @Override
    public List<BookDTO> getAllBooksByAuthorId(Long authorId) {
        Author author = getAuthor(authorId);
        return author.getBooks()
                .stream()
                .map(bookMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public BookDTO getBookByAuthorId(Long authorId, Long bookId) {
        Book book = getBookForAuthor(authorId, bookId);
        return bookMapper.toDto(book);
    }

    @Override
    public BookDTO updateBook(Long authorId, Long bookId, BookDTO bookDTO) {
        Book book = getBookForAuthor(authorId, bookId);

        book.setTitle(bookDTO.getTitle());
        book.setPublishedDate(bookDTO.getPublishedDate());
        Book updatedBook = bookRepository.save(book);
        return bookMapper.toDto(updatedBook);
    }

    @Override
    public void deleteBook(Long authorId, Long bookId) {
        Book book = getBookForAuthor(authorId, bookId);
        bookRepository.delete(book);
    }
}
