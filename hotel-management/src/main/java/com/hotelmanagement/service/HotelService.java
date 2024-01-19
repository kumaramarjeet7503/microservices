package com.hotelmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hotelmanagement.entities.Hotel;
import com.hotelmanagement.repo.HotelRepo;

@Service
public class HotelService {
    
    @Autowired
    private HotelRepo hotelRepo ;

    public List<Hotel> getHotels()
    {
        return  this.hotelRepo.findAll() ;
    }

    public Hotel createHotel(Hotel hotel)
    {
        return this.hotelRepo.save(hotel) ;
    }

    // public Hotel getHotel(String hotelId)
    // {
    //     return this.hotelRepo.findById(hotelId) ;
    // }
}
