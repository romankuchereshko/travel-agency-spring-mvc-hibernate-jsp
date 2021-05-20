package com.travel.agency.service;

import com.travel.agency.dao.RoomDao;
import com.travel.agency.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class RoomServiceImpl implements RoomService {
    private final RoomDao roomDao;

    @Autowired
    public RoomServiceImpl(RoomDao roomDao) {
        this.roomDao = roomDao;
    }

    @Override
    public void add(Room room) {
        roomDao.add(room);
    }
}
