package com.travel.agency.dao;

import com.travel.agency.model.Room;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class RoomDaoImpl implements RoomDao {
    private SessionFactory sessionFactory;

    public RoomDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Room room) {
        sessionFactory.getCurrentSession().save(room);
        log.info("Room successfully added!");
    }
}
