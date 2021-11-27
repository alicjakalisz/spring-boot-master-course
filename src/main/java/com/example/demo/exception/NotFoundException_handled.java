package com.example.demo.exception;




public class NotFoundException_handled extends RuntimeException{
    public NotFoundException_handled(String message){
        super(message);
    }
}
