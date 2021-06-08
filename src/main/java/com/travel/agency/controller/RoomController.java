package com.travel.agency.controller;

import com.travel.agency.converter.DtoConverter;
import com.travel.agency.dto.BookingDto;
import com.travel.agency.dto.RoomDto;
import com.travel.agency.model.BedPreference;
import com.travel.agency.model.Hotel;
import com.travel.agency.model.Room;
import com.travel.agency.model.Status;
import com.travel.agency.service.HotelService;
import com.travel.agency.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/add/{hotel_id}")
    public String addRoom(@PathVariable(name = "hotel_id") Long hotelId, Model model) {
        model.addAttribute("room", new RoomDto().withHotelId(hotelId));
        model.addAttribute("beds", BedPreference.values());
        return "add-room";
    }

    @PostMapping("/add")
    public String addRoom(@ModelAttribute RoomDto roomDto, @RequestParam(value = "hotelId") Long hotelId) {
        Room room = dtoConverter.convertToEntity(roomDto.withHotelId(hotelId), new Room());
        room.setHotel(hotelService.findById(roomDto.getHotelId()));
        roomService.add(room);
        return "all-rooms-in-hotel";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/deleteRoom/{id}")
    public String deleteRoom(Model model, @PathVariable Long id) {
        Hotel hotel = roomService.findById(id).getHotel();
        List<Room> rooms = roomService.getAllRoomsByHotelId(hotel.getId());
        roomService.delete(id);
        model.addAttribute("rooms", rooms);
        return "all-rooms-in-hotel";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/all_rooms_in_hotel/{id}")
    public String allHotelRooms(@PathVariable Long id, Model model) {
        List<Room> rooms = roomService.getAllRoomsByHotelId(id);
        model.addAttribute("rooms", rooms);
        return "check-room";
    }

    @PostMapping("/available_room/{id}")
    public String checkIfRoomAvailableInHotel(@PathVariable(name = "id") Long roomId,
                                              @RequestParam(value = "checkIn") String checkIn,
                                              @RequestParam(value = "checkOut") String checkOut,
                                              @RequestParam(value = "hotelId") Long hotelId,
                                              Model model) {
        boolean isAvailable;
        try {
            isAvailable = roomService.checkIfRoomAvailableInHotel(
                    new BookingDto(roomId, LocalDate.parse(checkIn), LocalDate.parse(checkOut)));
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            model.addAttribute("rooms", roomService.getAllRoomsByHotelId(hotelId));
            return "check-room";
        }

        if (isAvailable) {
            model.addAttribute("id", roomId);
            model.addAttribute("checkIn", checkIn);
            model.addAttribute("checkOut", checkOut);
            return "book-room";
        } else {
            model.addAttribute("errorMessage", "This room is not available!");
            model.addAttribute("rooms", roomService.getAllRoomsByHotelId(hotelId));
            return "check-room";
        }
    }
}
