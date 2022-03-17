package com.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.*;

@ResponseStatus(NOT_FOUND)
public class DespesaNotFoundException extends RuntimeException {
    public DespesaNotFoundException(String id) {
        super(String.format("Id não encontrado: " + id));
    }
}
