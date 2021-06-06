package com.travel.agency.dao;

import com.travel.agency.model.Country;
import com.travel.agency.model.Hotel;

import java.util.List;

public interface CountryDao {
    Country findById(Integer id);

    Country findByName(String name);

    List<Country> getAllCountries();

    List<Hotel> getAllHotelsInCountry(String country);
}
