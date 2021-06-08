package com.travel.agency.dao.impl;

import com.travel.agency.dao.RoomDao;
import com.travel.agency.dto.BookingDto;
import com.travel.agency.dto.RoomDto;
import com.travel.agency.model.Room;
import com.travel.agency.model.Status;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Repository
@Slf4j
public class RoomDaoImpl implements RoomDao {
    private final SessionFactory sessionFactory;

    public RoomDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public RoomDto add(Room room) {
        Serializable serializable = sessionFactory.getCurrentSession().save(room);
        if (serializable == null) {
            log.info("Adding room with id {} is failed! ", room.getId());
            return null;
        }
        log.info("Room with id {} added successfully! ", room.getId());
        return new RoomDto(null, room.getPrice(), room.getGuestsCount(), room.getBed());
    }

    @Override
    public void delete(Long id) {
        Room room = sessionFactory.getCurrentSession().load(Room.class, id);
        if (room != null) {
            room.setBookings(null);
            sessionFactory.getCurrentSession().delete(room);
            log.info("Room successfully deleted!");
        } else {
            log.info("Room wasn't deleted!");
        }
    }

    @Override
    public Room findById(Long id) {
        Room room = sessionFactory.getCurrentSession().load(Room.class, id);
        if (room == null) {
            log.info("Room with id {} doesn't exist", id);
        }
        return room;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Room> getAllRoomsByHotelId(Long id) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Room r where r.hotel.id=:id")
                .setParameter("id", id)
                .getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Room> getRoomsBookedInHotelOnDate(Long hotelId, LocalDate checkIn, LocalDate checkOut) {
        return sessionFactory.getCurrentSession()
                .createQuery(
                        "select b.room from Booking b where (b.checkIn <= :checkIn and  b.checkOut >= :checkOut) " +
                                "and b.room.hotel.id = :hotelId")
                .setParameter("checkIn", checkIn)
                .setParameter("checkOut", checkOut)
                .setParameter("hotelId", hotelId)
                .getResultList();
    }
}
