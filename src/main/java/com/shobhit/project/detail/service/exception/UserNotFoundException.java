package com.shobhit.project.detail.service.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(){
        this("Invalid id and password");
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
