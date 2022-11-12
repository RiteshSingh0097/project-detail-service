package com.shobhit.project.detail.service.exception;

public class InventoryNotFoundException extends RuntimeException{

    public InventoryNotFoundException(){
        this("Inventory not found");
    }

    public InventoryNotFoundException(String message) {
        super(message);
    }
}
