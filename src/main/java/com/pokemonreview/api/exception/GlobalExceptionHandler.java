package com.pokemonreview.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(PokemonNotFoundException.class)
    public ResponseEntity<ErorObject> handlePokemonNotFoundException(PokemonNotFoundException ex, WebRequest web) {
        ErorObject erorObject = new ErorObject();
        erorObject.setStatusCode(HttpStatus.NOT_FOUND.value());
        erorObject.setMassage(ex.getMessage());
        erorObject.setTimestamp(new Date());

        return new ResponseEntity<ErorObject>(erorObject, HttpStatus.NOT_FOUND);
    }
}
