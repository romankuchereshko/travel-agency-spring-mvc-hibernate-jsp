package com.travel.agency.dao;

import com.travel.agency.dto.BookingDto;
import com.travel.agency.model.Booking;
import com.travel.agency.model.Room;

import java.time.LocalDate;
import java.util.List;

public interface BookingDao {
    BookingDto save(Booking booking);

    void delete(Long id);

    Booking getByUserId(Long id);

    List<Booking> getAllBookings();
}
