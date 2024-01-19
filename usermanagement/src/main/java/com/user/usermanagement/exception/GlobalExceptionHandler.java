package com.user.usermanagement.exception;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.user.usermanagement.payload.APIResponse;

@RestControllerAdvice
public class GlobalExceptionHandler  {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<APIResponse> handleGlobalResponse(ResourceNotFoundException ex)
    {
        String message = ex.getMessage() ;
        APIResponse response =  APIResponse.builder().message(message).status(HttpStatus.NOT_FOUND).success(true).build() ;
        return new  ResponseEntity<APIResponse>(response,HttpStatus.NOT_FOUND) ;
    } 

}
