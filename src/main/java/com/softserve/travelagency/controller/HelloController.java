package com.softserve.travelagency.controller;

import com.softserve.travelagency.model.Country;
import com.softserve.travelagency.model.Hotel;
import com.softserve.travelagency.model.Room;
import com.softserve.travelagency.model.enums.RoomsType;
import com.softserve.travelagency.model.enums.Stars;
import com.softserve.travelagency.service.Country.CountryService;
import com.softserve.travelagency.service.Hotel.HotelService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
public class HelloController {
    @Autowired
    private CountryService countryService;
    @Autowired
    private HotelService hotelService;

    @RequestMapping("/hello")
    public String printWelcome() {
        return "hello";
    }

    @RequestMapping("/error")
    public String error() {
        return "error";
    }

    @RequestMapping("/training")
    public String training() {
        return "training";
    }

    @GetMapping("/admin/list")
    public String listCountry(Model model) {
        List<Country> countries = countryService.getCountries();

        model.addAttribute("countries", countries);
        model.addAttribute("stars", Stars.values());
        return "admin";
    }
}
