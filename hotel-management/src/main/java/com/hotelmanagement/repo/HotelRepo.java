package com.hotelmanagement.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hotelmanagement.entities.Hotel;

@Repository
public interface HotelRepo extends MongoRepository <Hotel, String> {
    
}
