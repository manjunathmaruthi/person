package com.manjunath.person.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PersonNotFoundException extends RuntimeException {

    public PersonNotFoundException(String message){
        super(message);
    }


    public PersonNotFoundException(String message, Throwable t){
        super(message,t);
    }
}
