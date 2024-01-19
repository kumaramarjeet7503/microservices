package com.user.usermanagement.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.user.usermanagement.entities.User;
import com.user.usermanagement.exception.ResourceNotFoundException;
import com.user.usermanagement.repository.UserRepo;


import com.user.usermanagement.helper.Utils;
@Service
public class UserService {
    @Autowired
    private UserRepo userRepo ;

    @Autowired 
    private Utils utils ;

    public List<User> getAllUsers()
    {
        return   this.userRepo.findAll() ;
    }

    public User getUser(String userId)
    {
        return   this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("Please enter a valid user id")) ;
    }

    public User createUser(User user)
    {
        user.setId(utils.generateRandomId());
        User newUser = this.userRepo.save(user) ;
        return  newUser ;
    }
}
