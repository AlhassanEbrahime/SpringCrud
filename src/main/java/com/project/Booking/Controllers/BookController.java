package com.project.Booking.Controllers;
import com.project.Booking.DTOs.BookDTO;
import com.project.Booking.Services.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping("api/v1/authors/{authorId}/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;


    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks(@PathVariable Long authorId){
        List<BookDTO> books = bookService.getAllBooksByAuthorId(authorId);
        return ResponseEntity.ok(books);
    }


    @PostMapping
    public ResponseEntity<BookDTO> createBook(@PathVariable Long authorId,
                                              @Valid @RequestBody BookDTO bookDTO){
        BookDTO createdBook = bookService.creatBook(authorId,bookDTO);
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }

    @GetMapping({"/{bookId}"})
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long authorId,
                                               @PathVariable Long bookId){
        BookDTO book = bookService.getBookByAuthorId(authorId,bookId);
        return ResponseEntity.ok(book);
    }


    @PutMapping("/{bookId}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable Long authorId ,
                                              @PathVariable Long bookId,
                                              @Valid @RequestBody BookDTO bookDTO){
        BookDTO updateBook = bookService.updateBook(authorId, bookId, bookDTO);
        return ResponseEntity.ok(updateBook);
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long authorId,
                                           @PathVariable Long bookId){
        bookService.deleteBook(authorId, bookId);
        return ResponseEntity.noContent().build();
    }


}
