package com.manjunath.person.address.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AddressNotFoundException extends RuntimeException {

    public AddressNotFoundException(String message){
        super(message);
    }


    public AddressNotFoundException(String message, Throwable t){
        super(message,t);
    }
}
