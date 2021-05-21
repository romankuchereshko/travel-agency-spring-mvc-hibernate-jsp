package com.travel.agency.service;

import com.travel.agency.dao.HotelDao;
import com.travel.agency.dao.HotelDaoImpl;
import com.travel.agency.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelServiceImpl implements HotelService {
    private final HotelDao hotelDao;

    @Autowired
    public HotelServiceImpl(HotelDao hotelDao) {
        this.hotelDao = hotelDao;
    }

    @Override
    @Transactional
    public void add(Hotel hotel) {
        hotelDao.add(hotel);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Hotel> getAllHotels() {
        List<Hotel> hotels = hotelDao.getAllHotels();
        if (hotels.isEmpty()) {
            return new ArrayList<>();
        }
        return hotels;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Hotel> getHotelsInCurrentCountry(String country) {
        List<Hotel> hotels = hotelDao.getAllHotels().stream()
                .filter(hotel -> hotel.getCountry().toString().equals(country))
                .collect(Collectors.toList());
        if (hotels.isEmpty()) {
            return new ArrayList<>();
        }
        return hotels;
    }
}
