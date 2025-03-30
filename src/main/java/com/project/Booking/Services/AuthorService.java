package com.project.Booking.Services;

import com.project.Booking.DTOs.AuthorDTO;
import com.project.Booking.Entites.Author;

import java.util.List;

public interface AuthorService {

    List<AuthorDTO> getAllAuthors();
    AuthorDTO createAuthor(AuthorDTO authorDTO);
    AuthorDTO getAuthorById(Long id);
    AuthorDTO UpdateAuthor(Long id, AuthorDTO authorDTO);
    void deleteAuthor(Long id);
}
