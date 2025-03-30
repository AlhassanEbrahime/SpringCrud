package com.project.Booking.Controllers;


import com.project.Booking.DTOs.AuthorDTO;
import com.project.Booking.Services.AuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;


    @GetMapping
    public ResponseEntity<List<AuthorDTO>> getAllAuthor(){
        List<AuthorDTO> authors = authorService.getAllAuthors();
        return ResponseEntity.ok(authors);
    }

    @PostMapping
    public ResponseEntity<AuthorDTO> createAuthor(@Valid @RequestBody AuthorDTO authorDTO){
        AuthorDTO createdAuthor = authorService.createAuthor(authorDTO);
        return new ResponseEntity<>(createdAuthor, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDTO> getAuthorById(@PathVariable Long id){
        AuthorDTO author = authorService.getAuthorById(id);
        return ResponseEntity.ok(author);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorDTO> updateAuthor(@PathVariable Long id,
                                                  @Valid @RequestBody AuthorDTO authorDto){
        AuthorDTO updatedAuthor = authorService.UpdateAuthor(id, authorDto);
        return ResponseEntity.ok(updatedAuthor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id){
        authorService.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }












}
