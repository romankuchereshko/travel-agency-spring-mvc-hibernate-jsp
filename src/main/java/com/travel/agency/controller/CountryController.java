package com.travel.agency.controller;

import com.travel.agency.model.Country;
import com.travel.agency.service.CountryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/country")
public class CountryController {
    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/countries")
    public String getCountries(Model model) {
        List<Country> countries = countryService.getAllCountries();
        model.addAttribute("countries", countries);
        return "countries";
    }

    @PostMapping("/getAllHotelsInCountry")
    public String getAllHotelsInCountry(@RequestParam("country") String country) {
        Long countryId = countryService.findByName(country).getId();
        return "redirect:/hotels/allHotelsInCountry/" + countryId;
    }
}
