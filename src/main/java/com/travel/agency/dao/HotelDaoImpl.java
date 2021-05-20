package com.travel.agency.dao;

import com.travel.agency.model.Hotel;
import com.travel.agency.model.User;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Slf4j
public class HotelDaoImpl implements HotelDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Hotel hotel) {
        entityManager.unwrap(Session.class).save(hotel);
        log.info("Hotel successfully added!");
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Hotel> getAllHotels() {
        List<Hotel> hotels = entityManager.createQuery("SELECT h FROM Hotel h ORDER BY h.id", Hotel.class).getResultList();
        for (Hotel hotel : hotels) {
            log.info("Hotel List::" + hotel);
        }
        return hotels;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Hotel> getHotelsInCurrentCountry(String country) {
        List<Hotel> allHotels = entityManager.createQuery("from User").getResultList();
        return allHotels.stream()
                .filter(hotel -> hotel.getCountry().name().equals(country))
                .peek(hotel -> log.info("Hotel List::" + hotel))
                .collect(Collectors.toList());
    }
}
