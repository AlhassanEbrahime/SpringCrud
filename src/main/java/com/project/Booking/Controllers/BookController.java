package com.project.Booking.Controllers;

import com.project.Booking.DTOs.BookDTO;
import com.project.Booking.Services.serviceinterfaces.BookService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks(){
        List<BookDTO> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }


    @PostMapping
    public ResponseEntity<BookDTO> createBook(@Valid @RequestBody BookDTO bookDTO){
        BookDTO createdBook = bookService.creatBook(bookDTO);
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long id){
        BookDTO book = bookService.getBookById(id);
        return ResponseEntity.ok(book);
    }


    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable Long id ,
                                              @Valid @RequestBody BookDTO bookDTO){
        BookDTO updateBook = bookService.updateBook(id, bookDTO);
        return ResponseEntity.ok(updateBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }


}
