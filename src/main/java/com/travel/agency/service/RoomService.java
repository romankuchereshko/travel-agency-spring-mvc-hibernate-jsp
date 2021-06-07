package com.travel.agency.service;

import com.travel.agency.dto.BookingDto;
import com.travel.agency.dto.RoomDto;
import com.travel.agency.model.Room;

import java.time.LocalDate;
import java.util.List;

public interface RoomService {
    RoomDto add(Room room);

    void delete(Long id);

    Room findById(Long id);

    List<Room> getAllRoomsByHotelId(Long id);

    boolean checkIfRoomAvailableInHotel(BookingDto bookingDto);

//    List<Room> getRoomsBookedInHotelOnDate(Long hotelId, LocalDate checkIn, LocalDate checkOut);
}
