package com.crudExample.assisiments.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public @ResponseStatus(HttpStatus.BAD_REQUEST)
class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}
