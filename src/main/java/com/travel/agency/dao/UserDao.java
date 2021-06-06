package com.travel.agency.dao;

import com.travel.agency.model.Booking;
import com.travel.agency.model.User;

import java.util.List;

public interface UserDao {
    User getByEmail(String email);

    User getById(Long id);

    User getByName(String name);

    List<User> getAllUsers();

    List<Booking> getUserBookingsById(Long id);
}
