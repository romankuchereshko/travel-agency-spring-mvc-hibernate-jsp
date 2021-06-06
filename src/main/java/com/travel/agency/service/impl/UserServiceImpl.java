package com.travel.agency.service.impl;

import com.travel.agency.dao.UserDao;
import com.travel.agency.model.Booking;
import com.travel.agency.model.User;
import com.travel.agency.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getByEmail(String email) {
        return userDao.getByEmail(email);
    }

    @Override
    public User getById(Long id) {
        return userDao.getById(id);
    }

    @Override
    public User getByName(String name) {
        return userDao.getByName(name);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userDao.getAllUsers();
        if (users.isEmpty()) {
            return new ArrayList<>();
        }
        return users;
    }

    @Override
    public List<Booking> getUsersBookingsById(Long id) {
        return userDao.getUserBookingsById(id);
    }
}
