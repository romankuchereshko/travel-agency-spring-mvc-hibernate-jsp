package com.travel.agency.dao;

import com.travel.agency.model.Country;
import com.travel.agency.model.Hotel;

import java.util.List;

public interface HotelDao {
    void add(Hotel hotel);
    List<Hotel> getAllHotels();
    List<Hotel> getHotelsInCurrentCountry(String country);
}
