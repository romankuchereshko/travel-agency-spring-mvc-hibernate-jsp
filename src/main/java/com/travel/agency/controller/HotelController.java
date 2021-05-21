package com.travel.agency.controller;

import com.travel.agency.model.Hotel;
import com.travel.agency.service.BookingService;
import com.travel.agency.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;

@Controller
@RequestMapping("/hotels")
public class HotelController {
    private final HotelService hotelService;
    private final BookingService bookingService;

    @Autowired
    public HotelController(HotelService hotelService, BookingService bookingService) {
        this.hotelService = hotelService;
        this.bookingService = bookingService;
    }

    @GetMapping("/add")
    public String addHotelForm(Model model) {
        model.addAttribute("hotel", new Hotel());
        return "add-hotel";
    }

    @PostMapping("/add")
    public String addHotel(Hotel hotel) {
        hotelService.add(hotel);
        return "redirect:/home";
    }

    @GetMapping("/all")
    public String getAllHotels(Model model) {
        model.addAttribute("hotels", hotelService.getAllHotels());
        return "hotels";
    }

    @GetMapping("/all/{country}")
    public String getAllHotelsInCountry(@PathVariable String country, Model model) {
        if (country.isEmpty()) {
            model.addAttribute("hotels", hotelService.getAllHotels());
        } else {
            model.addAttribute("hotels", hotelService.getHotelsInCurrentCountry(country));
            model.addAttribute("country", country);
        }
        return "hotels";
    }

    @GetMapping("/check")
    public String checkIfAvailable(Hotel hotel, Date date) {
        if (bookingService.checkAvailableRoomsInHotelByDate(hotel, date)) {
            return "redirect:/booking/book";
        } else {
            return "redirect:/home";
        }
    }
}
