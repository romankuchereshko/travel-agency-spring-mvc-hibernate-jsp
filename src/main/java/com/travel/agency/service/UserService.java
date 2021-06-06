package com.travel.agency.service;

import com.travel.agency.model.Booking;
import com.travel.agency.model.User;

import java.util.List;

public interface UserService {
    User getByEmail(String email);

    User getById(Long id);

    User getByName(String name);

    List<User> getAllUsers();

    List<Booking> getUsersBookingsById(Long id);
}
