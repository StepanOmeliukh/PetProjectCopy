package com.softserve.travelagency.controller;

import com.softserve.travelagency.model.Country;
import com.softserve.travelagency.service.Country.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    public String listCountry(Model model) {
        List<Country> countries = countryService.getCountries();
        model.addAttribute("countries", countries);
        return "booking";
    }
}