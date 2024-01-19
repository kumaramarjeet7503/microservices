package com.hotelmanagement.controllers;

import org.springframework.web.bind.annotation.RestController;
import com.hotelmanagement.service.HotelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.hotelmanagement.entities.Hotel;
import java.util.* ;

@RestController
public class HotelController {
    
    private HotelService hotelService ;

    @GetMapping("/get-hotels")
    public List<Hotel> getAllHotels() {
        List<Hotel> hotels = this.hotelService.getHotels() ;
        return  hotels ;
    }
    
        @PostMapping("/create-hotel")
    public Hotel createAllHotel(@RequestBody Hotel hotel)
    {
        Hotel newHotel = this.hotelService.createHotel(hotel) ;
        return newHotel ;
    }
    
}
