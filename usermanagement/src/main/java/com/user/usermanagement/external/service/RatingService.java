package com.user.usermanagement.external.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.user.usermanagement.entities.Rating;

@FeignClient(name = "RATING-MANAGEMENT")
public interface RatingService {
    
    @GetMapping("/rating/user/get-rating/{userId}")
    public List<Rating> getRatingByUser(@PathVariable String userId) ;
}
