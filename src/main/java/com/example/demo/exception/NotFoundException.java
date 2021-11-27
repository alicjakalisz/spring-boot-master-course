package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND) // exception will be thrown in service and pass to the client through controller with this status Not Found.
public class NotFoundException extends RuntimeException{
    public NotFoundException(String message){
        super(message);
    }
}
