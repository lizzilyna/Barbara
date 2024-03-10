package it.epicode.Barbara.exceptions;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ResponseExceptionHandler {
    @ExceptionHandler(NotFoundException.class)//questa annotazione prevede il nome della classe che deve gestire
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse NotFoundExceptionHandler (NotFoundException e){
        return new ErrorResponse(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public ErrorResponse ExceptionHandler (Exception e){
        return new ErrorResponse(e.getMessage());
    }
}
