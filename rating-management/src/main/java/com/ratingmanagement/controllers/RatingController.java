package com.ratingmanagement.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.ratingmanagement.entities.Rating;
import com.ratingmanagement.service.RatingService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class RatingController {
    
    @Autowired
    public RatingService ratingService ;

    @GetMapping("/get-ratings")
    public List<Rating> getAllRating() {
        return  this.ratingService.getAllRatings() ;
    }
    
    @PostMapping("/create-rating")
    public Rating createRating(@RequestBody Rating rating)
    {
        Rating newRating = this.ratingService.createRating(rating) ;
        return newRating ;
    }
    
}
