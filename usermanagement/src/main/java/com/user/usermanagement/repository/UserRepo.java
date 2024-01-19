package com.user.usermanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.usermanagement.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User,String> {
    
    public abstract List<User> findAll() ;

}
