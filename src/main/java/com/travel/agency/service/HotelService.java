package com.travel.agency.service;

import com.travel.agency.dto.HotelDto;
import com.travel.agency.model.Hotel;

import java.util.List;

public interface HotelService {
    HotelDto add(Hotel hotel);

    void delete(Long id);

    List<Hotel> getAllHotels();

    Hotel findById(Long id);

    List<Hotel> findByCountryId(Long id);
}
