package com.kata.katabackend.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ErrorDetails {

    private HttpStatus status;
    private String message;

}
