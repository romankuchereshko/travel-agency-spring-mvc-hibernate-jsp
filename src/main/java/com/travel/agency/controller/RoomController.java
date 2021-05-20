package com.travel.agency.controller;

import com.travel.agency.model.Room;
import com.travel.agency.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rooms")
public class RoomController {
    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/add")
    public String addRoom() {
        return "add-room";
    }

    @PostMapping("/add")
    public String addRoom(Room room) {
        roomService.add(room);
        return "redirect:/home";
    }
}
