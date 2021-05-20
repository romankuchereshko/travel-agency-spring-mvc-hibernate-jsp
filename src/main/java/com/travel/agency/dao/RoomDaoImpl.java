package com.travel.agency.dao;

import com.travel.agency.model.Room;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Slf4j
public class RoomDaoImpl implements RoomDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Room room) {
        entityManager.unwrap(Session.class).save(room);
        log.info("Room successfully added!");
    }
}
