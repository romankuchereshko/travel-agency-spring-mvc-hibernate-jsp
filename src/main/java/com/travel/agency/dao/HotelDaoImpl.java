package com.travel.agency.dao;

import com.travel.agency.model.Hotel;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@Slf4j
public class HotelDaoImpl implements HotelDao {

    private SessionFactory sessionFactory;

    public HotelDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Hotel hotel) {
        sessionFactory.getCurrentSession().save(hotel);
        log.info("Hotel successfully added!");
    }

    @Override
    public List<Hotel> getAllHotels() {
        List<Hotel> hotels = sessionFactory.getCurrentSession()
                .createQuery("SELECT h FROM Hotel h ORDER BY h.id", Hotel.class)
                .getResultList();
        for (Hotel hotel : hotels) {
            log.info("Hotel List::" + hotel);
        }
        return hotels;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Hotel> getHotelsInCurrentCountry(String country) {
        List<Hotel> allHotels = sessionFactory.getCurrentSession()
                .createQuery("from User")
                .getResultList();
        return allHotels.stream()
                .filter(hotel -> hotel.getCountry().name().equals(country))
                .peek(hotel -> log.info("Hotel List::" + hotel))
                .collect(Collectors.toList());
    }
}
