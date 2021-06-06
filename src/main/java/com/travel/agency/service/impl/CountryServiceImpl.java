package com.travel.agency.service.impl;

import com.travel.agency.dao.CountryDao;
import com.travel.agency.model.Country;
import com.travel.agency.model.Hotel;
import com.travel.agency.service.CountryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CountryServiceImpl implements CountryService {
    private final CountryDao countryDao;

    public CountryServiceImpl(CountryDao countryDao) {
        this.countryDao = countryDao;
    }

    @Override
    public Country findById(Integer id) {
        return countryDao.findById(id);
    }

    @Override
    public Country findByName(String name) {
        return countryDao.findByName(name);
    }

    @Override
    public List<Country> getAllCountries() {
        return countryDao.getAllCountries();
    }

    @Override
    public List<Hotel> getAllHotelsInCountry(String country) {
        return countryDao.getAllHotelsInCountry(country);
    }
}
