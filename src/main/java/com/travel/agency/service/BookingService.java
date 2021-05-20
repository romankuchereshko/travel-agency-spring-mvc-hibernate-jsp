package com.travel.agency.service;

import com.travel.agency.model.Booking;
import com.travel.agency.model.Hotel;

import java.sql.Date;
import java.util.List;

public interface BookingService {
    boolean book(Booking booking);
    Booking getBookingById(Long id);
    void cancelBooking(Long id);
    boolean checkAvailableRoomsInHotelByDate(Hotel hotel, Date date);
    List<Booking> getAllBookingsByUserId(Long id);
    List<Booking> getAllBookings();
}
