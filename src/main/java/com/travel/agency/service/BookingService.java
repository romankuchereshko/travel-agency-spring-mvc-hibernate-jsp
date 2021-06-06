package com.travel.agency.service;

import com.travel.agency.dto.BookingDto;
import com.travel.agency.model.Booking;
import com.travel.agency.model.Hotel;

import java.sql.Date;
import java.util.List;

public interface BookingService {
    BookingDto book(Booking booking);
    void cancel(Long id);
    Booking getBookingById(Long id);
    List<Booking> getBookingsByUserId(Long id);
    List<Booking> getAllBookings();
}
