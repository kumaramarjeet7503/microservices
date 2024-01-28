package com.user.usermanagement.external.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.user.usermanagement.entities.Hotel;

@FeignClient(name = "HOTEL-MANAGEMENT")
public interface HotelService {
    
    @GetMapping("/hotel/get-hotel/{hotelId}")
    public abstract Hotel getHotelById(@PathVariable String hotelId) ;

}
