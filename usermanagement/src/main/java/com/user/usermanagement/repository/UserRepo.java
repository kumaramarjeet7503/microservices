package com.user.usermanagement.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.user.usermanagement.entities.User;

@Repository
public interface UserRepo extends MongoRepository<User,String> {
    
    public abstract List<User> findAll() ;

}
