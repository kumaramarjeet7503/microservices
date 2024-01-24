package com.user.usermanagement.service;

import java.util.ArrayList;
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
import com.user.usermanagement.repository.UserRepo;


import com.user.usermanagement.helper.Utils;
@Service
public class UserService {
    @Autowired
    private UserRepo userRepo ;
    @Autowired
    private RestTemplate restTemplate ;
    private Logger logger = LoggerFactory.getLogger(UserService.class) ;

    @Autowired 
    private Utils utils ;
 
    public List<User> getAllUsers()
    {
        return   this.userRepo.findAll() ;
    }

    public User getUser(String userId)
    {
        User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("Please enter a valid user id"))  ; 
        String ratingUrl = "http://localhost:8092/user/get-rating/"+userId ;
        Rating[] rating = this.restTemplate.getForObject(ratingUrl, Rating[].class);
        
         List<Rating> ratings = Arrays.stream(rating).toList() ;
        String hotelUrl = "http://localhost:8093/get-hotel/" ;
         List<Rating> hotelRating = ratings.stream().map(ratingObj -> {
                ResponseEntity<Hotel> responseHotel = this.restTemplate.getForEntity(hotelUrl+ratingObj.getHotelId() ,Hotel.class) ;
                Hotel hotel = responseHotel.getBody() ;
                ratingObj.setHotel(hotel);
                return ratingObj ;
         }).collect(Collectors.toList())  ;

        user.setRatings(hotelRating);
        return  user  ;
    }

    public User createUser(User user)
    {
        user.setId(utils.generateRandomId());
        User newUser = this.userRepo.save(user) ;
        return  newUser ;
    }
}
