package com.project.Booking.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ErrorDetails {
    private final String message;
    private final int statusCode;
    private final Date timeStamp;
}
