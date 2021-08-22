package com.softserve.travelagency.controller;

import com.softserve.travelagency.model.Country;
import com.softserve.travelagency.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @PostMapping("/save")
    @PreAuthorize("hasAuthority('developers:edit')")
    public String saveCountry( Country country) { //@ModelAttribute("country")
        countryService.saveCountry(country);
        return "redirect:/admin/list";
    }
}