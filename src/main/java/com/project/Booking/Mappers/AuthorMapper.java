package com.project.Booking.Mappers;

import com.project.Booking.DTOs.AuthorDTO;
import com.project.Booking.Entites.Author;
import org.springframework.stereotype.Component;

public interface AuthorMapper {

    AuthorDTO toDto(Author author);

    Author toEntity(AuthorDTO authorDTO);

}
