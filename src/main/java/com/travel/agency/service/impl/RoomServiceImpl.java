package com.travel.agency.service.impl;

import com.travel.agency.dao.BookingDao;
import com.travel.agency.dao.HotelDao;
import com.travel.agency.dao.RoomDao;
import com.travel.agency.dto.BookingDto;
import com.travel.agency.dto.RoomDto;
import com.travel.agency.model.Booking;
import com.travel.agency.model.Room;
import com.travel.agency.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {
    private final RoomDao roomDao;
    private final BookingDao bookingDao;
    private final HotelDao hotelDao;

    @Autowired
    public RoomServiceImpl(RoomDao roomDao, BookingDao bookingDao, HotelDao hotelDao) {
        this.roomDao = roomDao;
        this.bookingDao = bookingDao;
        this.hotelDao = hotelDao;
    }

    @Override
    public RoomDto add(Room room) {
        return roomDao.add(room);
    }

    @Override
    public void delete(Long id) {
        roomDao.delete(id);
    }

    @Override
    public Room findById(Long id) {
        return roomDao.findById(id);
    }

    @Override
    public List<Room> getAllRoomsByHotelId(Long id) {
        return roomDao.getAllRoomsByHotelId(id);
    }

    @Override
    public boolean checkIfRoomAvailableInHotel(BookingDto bookingDto) {
//        LocalDate guestArriving = bookingDto.getCheckIn();
//        LocalDate guestCheckOut = bookingDto.getCheckOut();
//
//        List<Booking> allBookings = bookingDao.getAllBookings();
        List<Room> bookedRoomsOnDate = bookingDao.getRoomsBookedInHotelOnDate(
                bookingDto.getRoom().getHotel().getId(),
                bookingDto.getCheckIn(),
                bookingDto.getCheckOut());
        return !bookedRoomsOnDate.contains(bookingDto.getRoom());

//        List<Booking> bookings = bookingDto.getRoom().getBookings();
//
//        for (Booking b : bookings) {
//            LocalDate bookedArriving = b.getCheckIn();
//            LocalDate bookedCheckout = b.getCheckOut();
//            if (guestCheckOut.isBefore(bookedArriving) || guestArriving.isAfter(bookedCheckout)) {
//                return false;
//            }
//        }
//        return true;
    }

}