package com.travel.agency.controller;

import com.travel.agency.converter.DtoConverter;
import com.travel.agency.dto.BookingDto;
import com.travel.agency.model.Booking;
import com.travel.agency.model.Room;
import com.travel.agency.model.Status;
import com.travel.agency.model.User;
import com.travel.agency.service.BookingService;
import com.travel.agency.service.RoomService;
import com.travel.agency.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/booking")
//@Transactional
public class BookingController {
    private final BookingService bookingService;
    private final UserService userService;
    private final RoomService roomService;
    private final DtoConverter dtoConverter;

    @Autowired
    public BookingController(BookingService bookingService, UserService userService, RoomService roomService, DtoConverter dtoConverter) {
        this.bookingService = bookingService;
        this.userService = userService;
        this.roomService = roomService;
        this.dtoConverter = dtoConverter;
    }

    @PostMapping("/book/{id}")
    public String book(@PathVariable("id") Long roomId,
                       @RequestParam("checkIn")
                       @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkin,
                       @RequestParam("checkOut")
                       @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkout,
                       Principal principal) {
        Room room = roomService.findById(roomId);
        User user = userService.getByName(principal.getName());
        Booking booking = dtoConverter.convertToEntity(new BookingDto(roomId, checkin, checkout, Status.ACTIVE), new Booking());
        booking.setRoom(room);
        booking.setUser(user);
        bookingService.book(booking);
        return "success";
    }

//    @PostMapping("/available-room/{id}")
//    public String checkIfRoomAvailableInHotel(@PathVariable(name = "id") Long roomId,
//                                              @RequestParam(value = "checkIn") String checkIn,
//                                              @RequestParam(value = "checkOut") String checkOut,
//                                              @RequestParam(value = "hotelId") Long hotelId,
//                                              Model model) {
//        Room room = roomService.findById(roomId);
//        boolean isAvailable;
//        try {
//            isAvailable = roomService.checkIfRoomAvailableInHotel(
//                    new BookingDto(room, LocalDate.parse(checkIn), LocalDate.parse(checkOut), Status.NOT_ACTIVE));
//        } catch (IllegalArgumentException e) {
//            model.addAttribute("errorMessage", e.getMessage());
//            model.addAttribute("rooms", roomService.getAllRoomsByHotelId(hotelId));
//            return "check-room";
//        }
//
//        if (isAvailable) {
////            model.addAttribute("errorMessage", "");
//            model.addAttribute("id", roomId);
//            model.addAttribute("checkIn", checkIn);
//            model.addAttribute("checkOut", checkOut);
//            return "book-room";
//        } else {
//            model.addAttribute("errorMessage", "This room is not available!");
//            model.addAttribute("rooms", roomService.getAllRoomsByHotelId(hotelId));
//            return "check-room";
//        }
//    }

    @GetMapping("/delete/{id}")
    public String cancelBooking(@PathVariable("id") Long bookingId) {
            bookingService.cancel(bookingId);
            Long userId = bookingService.getBookingById(bookingId).getUser().getId();
            return "redirect:/booking/all/" + userId;
    }

    @GetMapping("/all/{id}")
    public String getAllBookingsByUserId(@PathVariable("id") Long userId, Model model) {
            model.addAttribute("all", bookingService.getBookingsByUserId(userId));
            model.addAttribute("user", userService.getById(userId));
        return "bookings-list";
    }

//    @GetMapping("/all/{id}")
//    public String getAllBookingsByUserId(@PathVariable("id") Long userId, Model model) {
//        if (userId != null) {
//            model.addAttribute("all", bookingService.getBookingsByUserId(userId));
//            model.addAttribute("user", userService.getById(userId));
//        } else {
//            model.addAttribute("all", bookingService.getAllBookings());
//            model.addAttribute("user", null);
//        }
//        return "bookings-list";
//    }
}
