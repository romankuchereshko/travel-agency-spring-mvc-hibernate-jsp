package com.travel.agency.service;

import com.travel.agency.dao.UserDao;
import com.travel.agency.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void createOrUpdate(User user) {
        userDao.create(user);
    }

    @Override
    public User read(Long id) {
        return userDao.read(id);
    }

    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userDao.getAllUsers();
        if (users.isEmpty()) {
            return new ArrayList<>();
        }
        return users;
    }
}
