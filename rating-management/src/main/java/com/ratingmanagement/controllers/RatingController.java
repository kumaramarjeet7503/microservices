package com.ratingmanagement.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.ratingmanagement.entities.Rating;
import com.ratingmanagement.service.RatingService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/rating")
public class RatingController {
    
    @Autowired
    public RatingService ratingService ;

    @GetMapping("/get-ratings")
    public ResponseEntity<?> getAllRating() {
        List<Rating> newRating =   this.ratingService.getAllRatings() ;
        return ResponseEntity.status(HttpStatus.OK).body(newRating) ;
    }

    @GetMapping("/user/get-rating/{userId}")
    public ResponseEntity<?> getRatingByUser(@PathVariable String userId) {
        List<Rating> newRating =  this.ratingService.getRatingByUser(userId) ;
        return ResponseEntity.status(HttpStatus.OK).body(newRating) ;
    }

    @GetMapping("/hotel/get-rating/{hotelId}")
    public ResponseEntity<?> getRatingByHotel(@PathVariable String hotelId) {
        List<Rating> newRating =  this.ratingService.getRatingByHotel( hotelId) ;
        return ResponseEntity.status(HttpStatus.OK).body(newRating) ;
    }
    
    @PostMapping("/create-rating")
    public ResponseEntity<?> createRating(@RequestBody Rating rating)
    {
        Rating newRating = this.ratingService.createRating(rating) ;
        return ResponseEntity.status(HttpStatus.OK).body(newRating) ;
    }
    
}
