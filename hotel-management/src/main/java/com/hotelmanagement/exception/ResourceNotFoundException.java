package com.hotelmanagement.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class ResourceNotFoundException extends RuntimeException {
    
    public ResourceNotFoundException()
    {
        super("Resource Not Found !!") ;
    }

    public ResourceNotFoundException(String message)
    {
        super(message) ;
    }
}
