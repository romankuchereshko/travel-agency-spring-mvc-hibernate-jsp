package com.travel.agency.service;

import com.travel.agency.model.User;

import java.util.List;

public interface UserService {
    void createOrUpdate(User user);
    User read(Long id);
    void delete(Long id);
    List<User> getAllUsers();
}
