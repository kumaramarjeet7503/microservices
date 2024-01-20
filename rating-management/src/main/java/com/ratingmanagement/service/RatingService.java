package com.ratingmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratingmanagement.entities.Rating;
import com.ratingmanagement.repo.RatingRepo;

@Service
public class RatingService {
    
    @Autowired
    private RatingRepo ratingRepo ;

    public List<Rating>  getRatingByUser(String userId)
    {
        List<Rating> ratings = this.ratingRepo.findByUserId(userId) ;
        return ratings ;
    }

    public List<Rating>  getRatingByHotel(String hotelId)
    {
        List<Rating> ratings = this.ratingRepo.findByHotelId(hotelId) ;
        return ratings ;
    }

    public List<Rating> getAllRatings()
    {
        List<Rating> ratings = this.ratingRepo.findAll() ;
        return ratings ;
    }

    public Rating createRating(Rating rating)
    {
        Rating newRating = this.ratingRepo.save(rating) ;
        return newRating ;
    }
}
