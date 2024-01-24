package com.user.usermanagement.entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rating {
    
    private String ratingId ;
    private String userId ;
    private String hotelId ;
    private String feedback ;
    private int rating ;
    private Hotel hotel ;
}
