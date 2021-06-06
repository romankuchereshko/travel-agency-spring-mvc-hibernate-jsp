package com.travel.agency.controller;

import com.travel.agency.converter.DtoConverter;
import com.travel.agency.dto.HotelDto;
import com.travel.agency.model.AccommodationType;
import com.travel.agency.model.Hotel;
import com.travel.agency.service.BookingService;
import com.travel.agency.service.CountryService;
import com.travel.agency.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/hotels")
public class HotelController {
    private final HotelService hotelService;
    private final BookingService bookingService;
    private final CountryService countryService;
    private final DtoConverter dtoConverter;

    @Autowired
    public HotelController(HotelService hotelService, BookingService bookingService, CountryService countryService, DtoConverter dtoConverter) {
        this.hotelService = hotelService;
        this.bookingService = bookingService;
        this.countryService = countryService;
        this.dtoConverter = dtoConverter;
    }

    @GetMapping("/add")
    public String addHotelForm(Model model) {
        model.addAttribute("hotel", new HotelDto());
        model.addAttribute("countries", countryService.getAllCountries());
        model.addAttribute("type", AccommodationType.values());
        return "add-hotel";
    }

    @PostMapping("/add")
    public String addHotel(@ModelAttribute HotelDto hotelDto, BindingResult result) {
        if (result.hasErrors()) {
            return "add-hotel";
        }
        Hotel hotel = dtoConverter.convertToEntity(hotelDto, new Hotel());
        hotelService.add(hotel);
        return "add-room";
    }

    @GetMapping("/delete/{id}")
    public String deleteHotel(@PathVariable Long id) {
        hotelService.delete(id);
        return "hotels";
    }

    @GetMapping("/all")
    public String getAllHotels(Model model) {
        model.addAttribute("hotels", hotelService.getAllHotels());
        return "hotels";
    }

    @GetMapping("/allHotelsInCountry/{id}")
    public String getHotelsInCountry(@PathVariable("id") Long countryId, Model model) {
        List<Hotel> hotels = hotelService.findByCountryId(countryId);
        if (hotels.isEmpty()) {
            model.addAttribute("errorMessage", "There is no hotels in this country");
            model.addAttribute("countries", countryService.getAllCountries());
            return "hotels";
        }
        model.addAttribute("hotels", hotels);
        return "hotels-in-country";
    }
}
