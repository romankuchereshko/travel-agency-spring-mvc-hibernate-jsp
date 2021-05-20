package com.travel.agency.dao;

import com.travel.agency.model.User;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Slf4j
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(User user) {
        entityManager.unwrap(Session.class).saveOrUpdate(user);
        log.info("User created successfully! " + user);
    }

    @Override
    public User read(Long id) {
        User user = entityManager.find(User.class, id);
        log.info("User loaded successfully! " + user);
        return user;
    }

    @Override
    public void delete(Long id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
            log.info("User with id {} deleted successfully!", id);
        } else {
            log.info("User with id {} doesn't exist", id);
        }
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM User u ORDER BY u.id", User.class).getResultList();
    }
}
