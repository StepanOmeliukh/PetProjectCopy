package com.softserve.travelagency.controller;

import com.softserve.travelagency.model.Country;
import com.softserve.travelagency.model.Hotel;
import com.softserve.travelagency.service.Country.CountryService;
import com.softserve.travelagency.service.Hotel.HotelService;
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
    @Autowired
    private HotelService hotelService;

    @RequestMapping
    public String bookingPage() {
        return "booking";
    }

    @GetMapping
    public void listCountry(Model model) {
        List<Country> countries = countryService.getCountries();
        List<Hotel> hotels = hotelService.getHotels();


        model.addAttribute("countries", countries);
        model.addAttribute("hotels", hotels);
    }

    public void filterHotels() {

    }
//    @GetMapping
//    public void listHotel(Model model) {
////        return "booking";
//    }
}