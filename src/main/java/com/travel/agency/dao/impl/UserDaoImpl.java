package com.travel.agency.dao.impl;

import com.travel.agency.dao.UserDao;
import com.travel.agency.model.Booking;
import com.travel.agency.model.User;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class UserDaoImpl implements UserDao {
    private final SessionFactory sessionFactory;

    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User getByEmail(String email) {
        return (User) sessionFactory.getCurrentSession()
                .createQuery("FROM User u WHERE u.email=:email")
                .setParameter("email", email)
                .getSingleResult();
    }

    @Override
    public User getById(Long id) {
        return (User) sessionFactory.getCurrentSession()
                .createQuery("FROM User u WHERE u.id=:id")
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public User getByName(String name) {
        return (User) sessionFactory.getCurrentSession()
                .createQuery("FROM User u WHERE u.name=:name")
                .setParameter("name", name)
                .getSingleResult();
    }

    @Override
    public List<User> getAllUsers() {
        return sessionFactory.getCurrentSession()
                .createNativeQuery("select * from users", User.class)
                .getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Booking> getUserBookingsById(Long id) {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM Booking b WHERE b.user.id=:id")
                .setParameter("id", id)
                .getResultList();
    }
}
