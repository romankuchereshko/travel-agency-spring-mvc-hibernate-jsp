package com.travel.agency.service.impl;

import com.travel.agency.dao.RoomDao;
import com.travel.agency.dto.BookingDto;
import com.travel.agency.dto.RoomDto;
import com.travel.agency.model.Room;
import com.travel.agency.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {
    private final RoomDao roomDao;

    @Autowired
    public RoomServiceImpl(RoomDao roomDao) {
        this.roomDao = roomDao;
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
        List<Room> bookedRoomsOnDate = roomDao.getRoomsBookedInHotelOnDate(bookingDto.getRoomId(), bookingDto.getCheckIn(), bookingDto.getCheckOut());
        return !bookedRoomsOnDate.contains(roomDao.findById(bookingDto.getRoomId()));
    }
}
