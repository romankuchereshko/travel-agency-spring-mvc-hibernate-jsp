package com.travel.agency.dao;

import com.travel.agency.model.User;

import java.util.List;

public interface UserDao {
    void create(User user);
    User read(Long id);
    void delete(Long id);
    List<User> getAllUsers();
}
