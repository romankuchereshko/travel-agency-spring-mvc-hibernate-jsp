package com.travel.agency.service.impl;

import com.travel.agency.dao.HotelDao;
import com.travel.agency.dto.HotelDto;
import com.travel.agency.model.Hotel;
import com.travel.agency.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class HotelServiceImpl implements HotelService {
    private final HotelDao hotelDao;

    @Autowired
    public HotelServiceImpl(HotelDao hotelDao) {
        this.hotelDao = hotelDao;
    }

    @Override

    public HotelDto add(Hotel hotel) {
        return hotelDao.add(hotel);
    }

    @Override
    public void delete(Long id) {
        hotelDao.delete(id);
    }

    @Override
    public List<Hotel> getAllHotels() {
        List<Hotel> hotels = hotelDao.getAllHotels();
        if (hotels.isEmpty()) {
            return new ArrayList<>();
        }
        return hotels;
    }

    @Override
    public Hotel findById(Long id) {
        return hotelDao.findById(id);
    }

    @Override
    public List<Hotel> findByCountryId(Long id) {
        return hotelDao.getAllHotels();
    }

//    @Override
//    public List<Hotel> getHotelsInCurrentCountry(String country) {
//        List<Hotel> hotels = hotelDao.getAllHotels().stream()
//                .filter(hotel -> hotel.getCountry().toString().equals(country))
//                .collect(Collectors.toList());
//        if (hotels.isEmpty()) {
//            return new ArrayList<>();
//        }
//        return hotels;
//    }
}
