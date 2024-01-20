package com.ratingmanagement.exception;

public class ResourceNotFoundException extends RuntimeException {
    
    public ResourceNotFoundException()
    {
        super("The resource you are looking for is not found .") ;
    }

    public ResourceNotFoundException(String message)
    {
        super(message) ;
    }
}
