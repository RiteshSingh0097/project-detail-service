package com.shobhit.project.detail.service.exception;

public class ProductDetailsNotFoundException extends RuntimeException{

    public ProductDetailsNotFoundException(){
        this("Product details not found");
    }

    public ProductDetailsNotFoundException(String message) {
        super(message);
    }
}
