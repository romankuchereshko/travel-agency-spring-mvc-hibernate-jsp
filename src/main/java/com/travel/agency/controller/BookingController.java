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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/booking")
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
        Booking booking = dtoConverter.convertToEntity(new BookingDto(roomId, checkin, checkout), new Booking());
        booking.setRoom(room);
        booking.setUser(user);
        bookingService.book(booking);
        return "redirect:/success";
    }

    @GetMapping("/delete/{id}")
    public String cancelBooking(@PathVariable("id") Long bookingId) {
            bookingService.cancel(bookingId);
            Long userId = bookingService.getBookingById(bookingId).getUser().getId();
            return "redirect:/booking/all/" + userId;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/all/{id}")
    public String getAllBookingsByUserId(@PathVariable("id") Long userId, Model model) {
            model.addAttribute("all", bookingService.getBookingsByUserId(userId));
            model.addAttribute("user", userService.getById(userId));
        return "bookings-list";
    }
}
