package com.softserve.travelagency.controller;

import com.softserve.travelagency.model.*;


import com.softserve.travelagency.model.util.RoomType;
import com.softserve.travelagency.model.util.Stars;
import com.softserve.travelagency.service.BookingSrvice;
import com.softserve.travelagency.service.CountryService;
import com.softserve.travelagency.service.RoomService;
import com.softserve.travelagency.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private CountryService countryService;
    @Autowired
    private BookingSrvice bookingSrvice;
    @Autowired
    private RoomService roomService;
    @Autowired
    private UserService userService;

    @RequestMapping
    public String bookingPage() {
        return "booking";
    }

    @GetMapping
    public void listCountry(Model model) {
        List<Country> countries = countryService.getCountries();

        model.addAttribute("countries", countries);
        model.addAttribute("stars", Stars.values());
        model.addAttribute("roomsType", RoomType.values());
    }

    @PostMapping("/filter")
    public String filterHotels(Model model, Country country, Room room, Hotel hotel,
        @RequestParam("dateOfEntrance") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateOfEntrance,
        @RequestParam("dateOfDeparture") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateOfDeparture
    ) {
        List<Booking> bookings = bookingSrvice.getBookingByDate(                    // Getting list of booked rooms
                dateOfEntrance, dateOfDeparture, country.getCountryName(),
                room.getRoomsType(), hotel.getStars(), room.isCateringService()
        );
        List<Room> rooms = roomService.getRoomsByParams(                            // Getting list of rooms by params
                country.getCountryName(), room.getRoomsType(), hotel.getStars(), room.isCateringService()
        );

//      Checking if is booked room in room's list and remove it
        for (int i = 0; i < rooms.size(); i++)
            for (int k = 0; k < bookings.size(); k++) {
                Long bookRoom_id = bookings.get(k).getRoom().getId();
                Long room_id = rooms.get(i).getId();
                if (room_id.equals(bookRoom_id))
                    rooms.remove(i);
            }

        if (rooms.isEmpty())
            model.addAttribute("emptyRoom", 0);

//        Booking booking = new Booking();
//        booking.setDateOfEntrance(dateOfEntrance);
//        booking.setDateOfDeparture(dateOfDeparture);
        model.addAttribute("rooms", rooms);
//        model.addAttribute("bookings", booking);
        model.addAttribute("dateOfEntrance", dateOfEntrance);
        model.addAttribute("dateOfDeparture", dateOfDeparture);
        return "filteredBook";
//        TODO: через редірект не відображається циклічний блок jsp сторінки booking
    }

    @PostMapping("/book")
    public String book(@RequestParam(value = "id", required = false) Long id, Booking booking) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        User user = userService.getUserByEmail(username);

        Room room = roomService.getRoom(id);
        booking.setRoom(room);
        booking.setUser(user);
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        booking.setDateOfRegistration(LocalDate.now());
        bookingSrvice.saveBooking(booking);
        return "redirect:/booking";
    }
}