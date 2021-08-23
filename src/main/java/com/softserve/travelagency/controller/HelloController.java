package com.softserve.travelagency.controller;

import com.softserve.travelagency.model.Country;
import com.softserve.travelagency.model.util.Stars;
import com.softserve.travelagency.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HelloController {

    @GetMapping("/access-denied")
    public String getAccessDenied() {
        return "/error";
    }

     @Autowired
     private CountryService countryService;
    @PreAuthorize("hasAuthority('developers:edit')")
    @GetMapping("/admin/list")
    public String listCountry(Model model) {
        List<Country> countries = countryService.getCountries();

        model.addAttribute("countries", countries);
        model.addAttribute("stars", Stars.values());
        return "admin";
    }
}
