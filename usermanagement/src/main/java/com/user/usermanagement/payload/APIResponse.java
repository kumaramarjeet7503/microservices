package com.user.usermanagement.payload;

import org.springframework.http.HttpStatus;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class APIResponse {
    
    private String message ;
    private HttpStatus status ;
    private boolean success ;

}
