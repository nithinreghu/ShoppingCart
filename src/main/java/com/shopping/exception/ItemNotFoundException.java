package com.shopping.exception;

import lombok.Getter;

@Getter
public class ItemNotFoundException extends Exception{
    private String message;
    public ItemNotFoundException(String message){
        this.message = message;
    }

}
