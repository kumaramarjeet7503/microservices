package com.hotelmanagement.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Document(collection = "hotel")
public class Hotel {
    
    @Id
    private String id ;
    private String name ;
    private String location ;
    private String about ;
}
