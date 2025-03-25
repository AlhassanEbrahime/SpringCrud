package com.project.Booking.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BookDTO {
    private Long id;

    @NotBlank( message = "Title is mandatory")
    private String title;

    @NotBlank( message = "Author is mandatory")
    private String author;

    @NotNull(message = "Published date is mandatory")
    private LocalDate publishedDate;
}
