package com.user.usermanagement.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.user.usermanagement.entities.User;
import com.user.usermanagement.service.UserService;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("user/")
public class UserController {
    
    @Autowired
    private UserService userService ;

    private Logger logger = LoggerFactory.getLogger(UserController.class) ; 

    @GetMapping("/get-users")
    public ResponseEntity<?> getMethodName() {
        List<User> users = this.userService.getAllUsers() ;
        return ResponseEntity.ok(users) ;
    }

    @PostMapping("/create-user")
    public ResponseEntity<?> postMethodName(@RequestBody User user) {
       user.setActive(true);
        User newUser = this.userService.createUser(user) ; 
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(newUser) ;
    } 
    
    @GetMapping("/get-user/{userId}")
    public ResponseEntity<?> getUser(@PathVariable String userId) {
        User user = this.userService.getUser(userId) ;
        return ResponseEntity.ok(user) ;
    }
    
}
