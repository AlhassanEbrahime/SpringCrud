package com.project.Booking.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.Booking.Entites.Author;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BookDTO {

    @NotBlank( message = "Title is mandatory")
    private String title;

    @NotNull(message = "Published date is mandatory")
    private LocalDate publishedDate;
}
