package com.example.demo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice // so the class can work across all controllers in our api
public class ApiExceptionHandler {
    //we are going to build status response . There will be no json body received, no entity received but only response via ResponseEntity.
    //this method takes exception it is going to handle, build ..for out client and send response using response entity
    private final static Logger LOGGER = LoggerFactory.getLogger(ApiExceptionHandler.class);

    @ExceptionHandler(value=ApiRequestException.class) // we are marking this method as exception handler and passing exception type that you want to handle(if you use{} you can put there multiply exceptions
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e){
        //ApiException object takes info about the handle exception (message, type of exception), adds status and timing
        ApiException apiException = new ApiException(e.getMessage(), e,HttpStatus.BAD_REQUEST, ZonedDateTime.now());
        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
       // ResponseEntity.ok().body() normally you would return for example DTO object there with response Entity but this time only response.
        //Response will have json file and members like message, throwable,httpstatus,zonedatetime
    }

    @ExceptionHandler(value=NotFoundException_handled.class) // we are marking this method as exception handler and passing exception type that you want to handle(if you use{} you can put there multiply exceptions
    public ResponseEntity<Object> handleApiRequestException(NotFoundException_handled e){
        //ApiException object takes info about the handle exception (message, type of exception), adds status and timing
        ApiException apiException = new ApiException(e.getMessage(), e,HttpStatus.NOT_FOUND, ZonedDateTime.now());
        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
        // ResponseEntity.ok().body() normally you would return for example DTO object there with response Entity but this time only response.
        //Response will have json file and members like message, throwable,httpstatus,zonedatetime
    }
}
