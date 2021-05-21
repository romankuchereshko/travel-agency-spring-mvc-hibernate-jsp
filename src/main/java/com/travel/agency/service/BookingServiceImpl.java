package com.travel.agency.service;

import com.travel.agency.dao.BookingDao;
import com.travel.agency.model.Booking;
import com.travel.agency.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {
    private final BookingDao bookingDao;

    @Autowired
    public BookingServiceImpl(BookingDao bookingDao) {
        this.bookingDao = bookingDao;
    }

    @Override
    @Transactional
    public boolean book(Booking booking) {
        List<Booking> bookings = bookingDao.getAllBookings();
        Date guestArriving = booking.getArrival();
        Date guestCheckout = booking.getCheckout();

        for (Booking b : bookings) {
            Date bookedArriving = b.getArrival();
            Date bookedCheckout = b.getCheckout();
            if ((guestArriving.after(bookedArriving) && guestCheckout.before(bookedCheckout)) ||
                    (guestArriving.before(bookedArriving) && guestCheckout.after(bookedArriving)) ||
                    guestArriving.equals(bookedArriving)) {
                return false;
            }
        }
        return bookingDao.save(booking);
    }

    @Override
    @Transactional(readOnly = true)
    public Booking getBookingById(Long id) {
        return bookingDao.read(id);
    }

    @Override
    @Transactional
    public void cancelBooking(Long id) {
        bookingDao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean checkAvailableRoomsInHotelByDate(Hotel hotel, Date date) {
        return bookingDao.getAllBookings().stream()
                .filter(booking -> booking.getHotel().getName().equals(hotel.getName()))
                .filter(booking -> date.before(booking.getArrival()) || date.after(booking.getCheckout()))
                .anyMatch(booking -> booking.getRoom().getIsAvailable());
    }

    @Override
    @Transactional(readOnly = true)
    public List<Booking> getAllBookingsByUserId(Long id) {
        List<Booking> bookingList = bookingDao.getAllBookings();
        return bookingList.stream()
                .filter(booking -> booking.getUser().getId().equals(id))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<Booking> getAllBookings() {
        List<Booking> bookingList = bookingDao.getAllBookings();
        if (bookingList.isEmpty()) {
            return new ArrayList<>();
        }
        return bookingList;
    }
}
