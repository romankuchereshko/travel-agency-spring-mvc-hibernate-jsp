package com.travel.agency.dao;

import com.travel.agency.dto.RoomDto;
import com.travel.agency.model.Room;

import java.time.LocalDate;
import java.util.List;

public interface RoomDao {
    RoomDto add(Room room);

    void delete(Long id);

    Room findById(Long id);

    List<Room> getAllRoomsByHotelId(Long id);

    List<Room> getRoomsBookedInHotelOnDate(Long hotelId, LocalDate checkIn, LocalDate checkOut);
}
