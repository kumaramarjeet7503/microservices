package com.user.usermanagement.helper;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class Utils {
    
    public String generateRandomId()
    {
        UUID uuid = UUID.randomUUID() ;
        return uuid.toString() ;
    }
}
