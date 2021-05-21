package com.travel.agency.dao;

import com.travel.agency.model.Booking;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
@Slf4j
public class BookingDaoImpl implements BookingDao {

    private SessionFactory sessionFactory;

    public BookingDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public boolean save(Booking booking) {
        Serializable serializable = sessionFactory.getCurrentSession().save(booking);
        if (serializable != null) {
            log.info("Booked successfully! " + booking);
            return true;
        }
        return false;
    }

    @Override
    public Booking read(Long id) {
        return sessionFactory.getCurrentSession().load(Booking.class, id);
    }

    @Override
    public void delete(Long id) {
        Booking booking = sessionFactory.getCurrentSession().load(Booking.class, id);

        if (booking != null) {
            sessionFactory.getCurrentSession().delete(booking);
        }
        log.info("Booking canceled successfully! " + booking);
    }

    @Override
    public List<Booking> getAllBookings() {
        return sessionFactory.getCurrentSession()
                .createQuery("SELECT b FROM Booking b ORDER BY b.id", Booking.class)
                .getResultList();
    }

//    @SuppressWarnings("unchecked")
//    @Override
//    public List<Booking> getAllBookings() {
//        return entityManager.createQuery("SELECT b FROM Booking b ORDER BY b.id", Booking.class).getResultList();
//    }
}
