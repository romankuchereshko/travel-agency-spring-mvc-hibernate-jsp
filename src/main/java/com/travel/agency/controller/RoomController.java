package com.travel.agency.controller;

import com.travel.agency.converter.DtoConverter;
import com.travel.agency.dto.RoomDto;
import com.travel.agency.model.BedPreference;
import com.travel.agency.model.Hotel;
import com.travel.agency.model.Room;
import com.travel.agency.service.HotelService;
import com.travel.agency.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/rooms")
public class RoomController {
    private final RoomService roomService;
    private final HotelService hotelService;
    private final DtoConverter dtoConverter;

    @Autowired
    public RoomController(RoomService roomService, HotelService hotelService, DtoConverter dtoConverter) {
        this.roomService = roomService;
        this.hotelService = hotelService;
        this.dtoConverter = dtoConverter;
    }

    @GetMapping("/add/{hotel_id}")
    public String addRoom(@PathVariable(name = "hotel_id") Long hotelId, Model model) {
        Hotel hotel = hotelService.findById(hotelId);
        model.addAttribute("roomDto", new RoomDto());
        model.addAttribute("bed", BedPreference.values());
        model.addAttribute("hotel", hotel);
        model.addAttribute("country", hotel.getCountry());
        return "add-room";
    }

    @PostMapping("/add/")
    public String addRoom(@ModelAttribute RoomDto roomDto, BindingResult result) {
        if (result.hasErrors()) {
            return "add-room";
        }

        Room room = dtoConverter.convertToEntity(roomDto, new Room());
        roomService.add(room);
        return "all-rooms-in-hotel";
    }

    @PostMapping("/allHotelRooms/{id}")
    public String allHotelRooms(@PathVariable Long id, Model model) {
        List<Room> rooms = roomService.getAllRoomsByHotelId(id);
        model.addAttribute("rooms", rooms);
        return "check-room";
    }
}
