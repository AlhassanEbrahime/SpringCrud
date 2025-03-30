package com.project.Booking.Entites;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank( message = "Title is mandatory")
    private String title;

    @NotNull(message = "Published date is mandatory")
    private LocalDate publishedDate;

    @ManyToOne
    private Author author;


}
