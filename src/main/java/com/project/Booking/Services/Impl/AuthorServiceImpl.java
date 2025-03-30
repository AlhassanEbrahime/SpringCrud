package com.project.Booking.Services.Impl;

import com.project.Booking.DTOs.AuthorDTO;
import com.project.Booking.Entites.Author;
import com.project.Booking.Exceptions.ResourceNotFoundException;
import com.project.Booking.Mappers.AuthorMapper;
import com.project.Booking.Repositories.AuthorRepository;
import com.project.Booking.Services.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    private final AuthorMapper authorMapper;

    @Override
    public List<AuthorDTO> getAllAuthors() {
        return authorRepository.findAll()
                .stream()
                .map(authorMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AuthorDTO createAuthor(AuthorDTO authorDTO) {
        Author author = authorMapper.toEntity(authorDTO);
        Author savedAuthor = authorRepository.save(author);
        return authorMapper.toDto(savedAuthor);
    }

    @Override
    public AuthorDTO getAuthorById(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Author not found with id: "+ id));

        return authorMapper.toDto(author);
    }


    @Override
    public AuthorDTO UpdateAuthor(Long id, AuthorDTO authorDTO) {
        Author existingAuthor = authorRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Author not found with id: "+ id));

        existingAuthor.setName(authorDTO.getName());
        existingAuthor.setBirthdate(authorDTO.getBirthdate());

        Author updatedAuthor = authorRepository.save(existingAuthor);
        return authorMapper.toDto(updatedAuthor);
    }

    @Override
    public void deleteAuthor(Long id) {
       if(!authorRepository.existsById(id)){
           throw new ResourceNotFoundException("Author not fond with id: " + id);
       }
       authorRepository.deleteById(id);
    }
}
