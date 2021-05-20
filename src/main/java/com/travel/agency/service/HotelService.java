package com.travel.agency.service;

import com.travel.agency.model.Hotel;

import java.util.List;

public interface HotelService {
    void add(Hotel hotel);
    List<Hotel> getAllHotels();
    List<Hotel> getHotelsInCurrentCountry(String country);
}
