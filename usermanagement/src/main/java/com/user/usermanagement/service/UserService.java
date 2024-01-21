package com.user.usermanagement.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
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
        ArrayList rating = this.restTemplate.getForObject(ratingUrl, ArrayList.class);
        logger.info(rating.toString());
        user.setRatings(rating);
        return  user  ;
    }

    public User createUser(User user)
    {
        user.setId(utils.generateRandomId());
        User newUser = this.userRepo.save(user) ;
        return  newUser ;
    }
}
