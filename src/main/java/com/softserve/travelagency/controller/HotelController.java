
package com.softserve.travelagency.controller;

import com.softserve.travelagency.model.Country;
import com.softserve.travelagency.model.Hotel;
import com.softserve.travelagency.model.Room;
import com.softserve.travelagency.model.enums.RoomsType;
import com.softserve.travelagency.model.enums.Stars;
import com.softserve.travelagency.service.Country.CountryService;
import com.softserve.travelagency.service.Hotel.HotelService;
import com.softserve.travelagency.service.Room.RoomService;
import com.sun.xml.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;
    @Autowired
    private CountryService countryService;

    @PostMapping("/save")
    public String saveHotel( Hotel hotel, Country country) {
        Country countryForSave = countryService.getCountryByUsername(country.getCountryName());
        if (countryForSave.getCountryName().equals("No country selected"))
            return "redirect:/admin/list";

        hotel.setCountry(countryForSave);
        hotelService.saveHotel(hotel);
        return "redirect:/admin/list";
    }

    @GetMapping("/find")
    public String findByCountryName(Model model, Country country) {
        List<Country> countries = countryService.getCountries();
        List<Hotel> hotels = hotelService.findHotelByCountryName(country.getCountryName());


        model.addAttribute("countries", countries);
        model.addAttribute("filteredHotels", hotels);
        model.addAttribute("roomsType", RoomsType.values());
        return "admin";
    }
}
