package com.project.Booking.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AuthorDTO {


    @NotBlank(message = "Author name is mandatory")
    private String name ;

    @NotNull(message = "Birthdate is mandatory")
    private LocalDate birthdate;

}
