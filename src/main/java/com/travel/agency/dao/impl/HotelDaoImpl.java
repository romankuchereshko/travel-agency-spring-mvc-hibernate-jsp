package com.travel.agency.dao.impl;

import com.travel.agency.dao.HotelDao;
import com.travel.agency.dto.HotelDto;
import com.travel.agency.model.Hotel;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
@Slf4j
public class HotelDaoImpl implements HotelDao {

    private final SessionFactory sessionFactory;

    public HotelDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public HotelDto add(Hotel hotel) {
        Serializable serializable = sessionFactory.getCurrentSession().save(hotel);
        log.info("Hotel successfully added!");
        if (serializable == null) {
            log.info("Hotel with id {} wasn't created! ", hotel.getId());
            return null;
        }
        log.info("Hotel with id {} was created successfully! ", hotel.getId());
        return new HotelDto(
                hotel.getId(),
                hotel.getName(),
                hotel.getType(),
                hotel.getHasWiFi(),
                hotel.getHasPool(),
                hotel.getIsPetsAllowed(),
                hotel.getCanSmoke(),
                hotel.getRate(),
                hotel.getCountry());
    }

    @Override
    public void delete(Long id) {
        Hotel hotel = sessionFactory.getCurrentSession().load(Hotel.class, id);
        if (hotel != null) {
            sessionFactory.getCurrentSession().delete(hotel);
            log.info("Hotel successfully deleted!");
        } else {
            log.info("Hotel wasn't deleted");
        }
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

    @Override
    public Hotel findById(Long id) {
        Hotel hotel = sessionFactory.getCurrentSession().load(Hotel.class, id);
        if (hotel == null) {
            log.info("Hotel with id {} doesn't exist", id);
        }
        return hotel;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Hotel> findByCountryId(Long id) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Hotel h where h.country.id=:id")
                .setParameter("id", id)
                .getResultList();
    }

//    @SuppressWarnings("unchecked")
//    @Override
//    public List<Hotel> getHotelsInCurrentCountry(String country) {
//        List<Hotel> allHotels = sessionFactory.getCurrentSession()
//                .createQuery("from User")
//                .getResultList();
//        return allHotels.stream()
//                .filter(hotel -> hotel.getCountry().name().equals(country))
//                .peek(hotel -> log.info("Hotel List::" + hotel))
//                .collect(Collectors.toList());
//    }
}
