package com.hotelmanagement.controllers;

import org.springframework.web.bind.annotation.RestController;
import com.hotelmanagement.service.HotelService;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.hotelmanagement.entities.Hotel;
import java.util.* ;

@RestController
public class HotelController {
    
    @Autowired
    private HotelService hotelService ;

    @GetMapping("/get-hotels")
    public ResponseEntity<List<Hotel>> getAllHotels() {
        List<Hotel> hotels = this.hotelService.getHotels() ;
        return ResponseEntity.status(HttpStatus.OK).body(hotels) ;
    }
    
        @PostMapping("/create-hotel")
    public  ResponseEntity<?> createAllHotel(@RequestBody Hotel hotel)
    {
        Hotel newHotel = this.hotelService.createHotel(hotel) ;
        return ResponseEntity.status(HttpStatus.CREATED).body(newHotel) ;
    }

    @GetMapping("/get-hotel/{hotelId}")
    public ResponseEntity<?> getAllHotels(@PathVariable String hotelId) {
        Hotel hotels = this.hotelService.getHotel(hotelId) ;
        return ResponseEntity.status(HttpStatus.OK).body(hotels) ;
        
    }
    
    
}
