package com.travel.agency.service;

import com.travel.agency.model.Country;
import com.travel.agency.model.Hotel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryService {
    Country findById(Long id);

    Country findByName(String name);

    List<Country> getAllCountries();

    List<Hotel> getAllHotelsInCountry(String country);
}
