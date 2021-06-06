package com.travel.agency.service.impl;

import com.travel.agency.dao.BookingDao;
import com.travel.agency.dto.BookingDto;
import com.travel.agency.model.Booking;
import com.travel.agency.model.Status;
import com.travel.agency.service.BookingService;
import com.travel.agency.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {
    private final BookingDao bookingDao;
    private final RoomService roomService;

    @Autowired
    public BookingServiceImpl(BookingDao bookingDao, RoomService roomService) {
        this.bookingDao = bookingDao;
        this.roomService = roomService;
    }

    @Override
    public BookingDto book(Booking booking) {
        BookingDto bookingDto = new BookingDto(booking.getRoom(), booking.getCheckIn(), booking.getCheckOut(), Status.ACTIVE);
        if (roomService.checkIfRoomAvailableInHotel(bookingDto)) {
            return bookingDao.save(booking);
        }
        return null;
    }

    @Override
    public Booking getBookingById(Long id) {
        return bookingDao.getByUserId(id);
    }

    @Override
    public void cancel(Long id) {
        bookingDao.delete(id);
    }

    @Override
    public List<Booking> getBookingsByUserId(Long id) {
        List<Booking> bookingList = bookingDao.getAllBookings();
        return bookingList.stream()
                .filter(booking -> booking.getUser().getId().equals(id))
                .collect(Collectors.toList());
    }

    @Override
    public List<Booking> getAllBookings() {
        List<Booking> bookingList = bookingDao.getAllBookings();
        if (bookingList.isEmpty()) {
            return new ArrayList<>();
        }
        return bookingList;
    }
}
