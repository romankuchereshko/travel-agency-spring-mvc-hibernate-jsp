package com.travel.agency.dao;

import com.travel.agency.model.Booking;

import java.util.List;

public interface BookingDao {
    boolean save(Booking booking);
    Booking read(Long id);
    void delete(Long id);
    List<Booking> getAllBookings();
}
