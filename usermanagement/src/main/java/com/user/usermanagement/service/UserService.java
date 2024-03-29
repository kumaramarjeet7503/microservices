package com.user.usermanagement.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.usermanagement.entities.Hotel;
import com.user.usermanagement.entities.Rating;
import com.user.usermanagement.entities.User;
import com.user.usermanagement.exception.ResourceNotFoundException;
import com.user.usermanagement.external.service.HotelService;
import com.user.usermanagement.external.service.RatingService;
import com.user.usermanagement.repository.UserRepo;


import com.user.usermanagement.helper.Utils;
@Service
public class UserService {
    @Autowired
    private UserRepo userRepo ;
    @Autowired
    private RestTemplate restTemplate ;
    @Autowired
    private RatingService ratingService ;
    @Autowired
    private HotelService hotelService ;
    private Logger logger = LoggerFactory.getLogger(UserService.class) ;

    @Autowired 
    private Utils utils ;
 
    public List<User> getAllUsers()
    {           
        List<User> users =  this.userRepo.findAll() ;
        List<User> ratedUser = users.stream().map(user -> {
            List<Rating> ratings = setRatingFromResponse(user.getId()) ;
            user.setRatings(ratings);
            return user ;
        }).collect(Collectors.toList()) ;
        return ratedUser ;
    }

    public User getUser(String userId)
    {
        User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("Please enter a valid user id"))  ; 
     
        List<Rating> ratings = setRatingFromResponse(userId) ;
        user.setRatings(ratings);
        return  user  ;
    }

    public User createUser(User user)
    {
        user.setId(utils.generateRandomId());
        User newUser = this.userRepo.save(user) ;
        return  newUser ;
    }

    private List<Rating> setRatingFromResponse(String userId)
    {
        List<Rating> ratings = this.ratingService.getRatingByUser(userId);
         List<Rating> hotelRating = ratings.stream().map(ratingObj -> {
                // ResponseEntity<Hotel> responseHotel = this.restTemplate.getForEntity(hotelUrl+ratingObj.getHotelId() ,Hotel.class) ;
                Hotel hotel = hotelService.getHotelById(ratingObj.getHotelId()) ;
                ratingObj.setHotel(hotel);
                return ratingObj ;
         }).collect(Collectors.toList())  ;

         return hotelRating ;
    }
}
