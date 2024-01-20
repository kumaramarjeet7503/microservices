package com.hotelmanagement.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String,Object>> globalExceptionHandler(RuntimeException ex)
    {
        Map<String,Object> response = new HashMap<>() ;
        response.put("message",ex.getMessage()) ;
        response.put("status",HttpStatus.NOT_FOUND) ;
        response.put("success",false) ;

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response) ;
    }
}
