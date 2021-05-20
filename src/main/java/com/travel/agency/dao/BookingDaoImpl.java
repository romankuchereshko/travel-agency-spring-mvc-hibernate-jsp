package com.travel.agency.dao;

import com.travel.agency.model.Booking;
import com.travel.agency.model.User;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Repository
@Slf4j
public class BookingDaoImpl implements BookingDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean save(Booking booking) {
        Serializable serializable = entityManager.unwrap(Session.class).save(booking);
        if (serializable != null) {
            log.info("Booked successfully! " + booking);
            return true;
        }
        return false;
    }

    @Override
    public Booking read(Long id) {
        return entityManager.find(Booking.class, id);
    }

    @Override
    public void delete(Long id) {
        Booking booking = entityManager.find(Booking.class, id);

        if (booking != null) {
            entityManager.remove(booking);
        }
        log.info("Booking canceled successfully! " + booking);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Booking> getAllBookings() {
        return entityManager.createQuery("SELECT b FROM Booking b ORDER BY b.id", Booking.class).getResultList();
    }
}
