package com.project.Booking.Mappers.Impl;

import com.project.Booking.DTOs.AuthorDTO;
import com.project.Booking.Entites.Author;
import com.project.Booking.Mappers.AuthorMapper;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapperImpl implements AuthorMapper {

    @Override
    public AuthorDTO toDto(Author author) {
        if (author == null)
        {
            return null;
        }
        AuthorDTO dto = new AuthorDTO();
        dto.setName(author.getName());
        dto.setBirthdate(author.getBirthdate());

        return dto;
    }

    @Override
    public Author toEntity(AuthorDTO authorDTO) {

        if (authorDTO == null){
            return null;
        }
        Author author = new Author();
        author.setName(authorDTO.getName());
        author.setBirthdate(authorDTO.getBirthdate());
        return author;
    }
}
