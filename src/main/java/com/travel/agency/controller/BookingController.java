package com.travel.agency.controller;

import com.travel.agency.model.Booking;
import com.travel.agency.service.BookingService;
import com.travel.agency.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/booking")
public class BookingController {
    @Qualifier("bookingService")
    private final BookingService bookingService;
    private final UserService userService;

    @Autowired
    public BookingController(BookingService bookingService, UserService userService) {
        this.bookingService = bookingService;
        this.userService = userService;
    }

    @GetMapping("/book/user/{user_id}")
    public String book(@PathVariable Long user_id, Model model) {
        model.addAttribute("booking", new Booking());
        model.addAttribute("user_id", user_id);
        return "booking";
    }

    @PostMapping("/book/user/{user_id}")
    public String book(@PathVariable Long user_id, Booking booking) {
        booking.setUser(userService.read(user_id));
        if (bookingService.book(booking)) {
            return "success";
        } else {
            return "booking";
        }
    }

    @GetMapping("/delete/{user_id}/{booking_id}")
    public String cancelBooking(@PathVariable Long user_id, @PathVariable Long booking_id) {
        List<Booking> list = bookingService.getAllBookingsByUserId(user_id);
        if (list.contains(bookingService.getBookingById(booking_id))) {
            bookingService.cancelBooking(booking_id);
            return "success";
        } else {
            return "redirect:/home";
        }
    }

    @GetMapping("/all/{id}")
    public String getAllBookingsByUserId(@PathVariable Long id, Model model) {
        if (id != null) {
            model.addAttribute("all", bookingService.getAllBookingsByUserId(id));
        } else {
            model.addAttribute("all", bookingService.getAllBookings());
        }
        return "bookings-list";
    }
}
