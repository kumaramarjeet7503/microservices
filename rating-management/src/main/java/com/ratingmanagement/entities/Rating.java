package com.ratingmanagement.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.*;

@Document(collection = "rating")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rating {

    @Id
    private String ratingId ;
    private String userId ;
    private String hotelId ;
    private String feedback ;
    private int rating ;
}
