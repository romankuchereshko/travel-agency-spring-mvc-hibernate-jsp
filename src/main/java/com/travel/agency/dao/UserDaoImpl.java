package com.travel.agency.dao;

import com.travel.agency.model.User;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Slf4j
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(User user) {
        sessionFactory.getCurrentSession().save(user);
        log.info("User created successfully! " + user);
    }

    @Override
    public User read(Long id) {
        User user = sessionFactory.getCurrentSession().load(User.class, id);
        log.info("User loaded successfully! " + user);
        return user;
    }

    @Override
    public void delete(Long id) {
        User user = sessionFactory.getCurrentSession().load(User.class, id);
        if (user != null) {
            sessionFactory.getCurrentSession().delete(user);
            log.info("User with id {} deleted successfully!", id);
        } else {
            log.info("User with id {} doesn't exist", id);
        }
    }

    @Override
    public List<User> getAllUsers() {
        return sessionFactory.getCurrentSession().createNativeQuery("select * from users", User.class).getResultList();
    }

//    @Override
//    public List<User> getAllUsers() {
//        return sessionFactory.getCurrentSession().createQuery("SELECT u FROM User u ORDER BY u.id", User.class).getResultList();
//    }
}
