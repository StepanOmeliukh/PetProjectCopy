package com.softserve.travelagency.controller;

import com.softserve.travelagency.model.Hotel;
import com.softserve.travelagency.model.Room;
import com.softserve.travelagency.model.enums.RoomsType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String printWelcome() {
        return "hello";
    }

    @RequestMapping("/error")
    public String error() {
        return "error";
    }
    @RequestMapping("/login")
    public String login() {
        return "login";
    }
    @RequestMapping("/register")
    public String register() {
        return "register";
    }

//    @RequestMapping("/admin")
//    public String admin() {
//        return "admin";
//    }

//    @GetMapping("/addHotel")
////    @PreAuthorize("hasAuthority('developers:edit')")
//    public String newHotel(Model model) {
//        model.addAttribute("hotel", new Hotel());
//        model.addAttribute("countries", hotelService.getAllCountries());
//        return "new-hotel";
//    }
//
//    @PostMapping("/addHotel")
////    @PreAuthorize("hasAuthority('developers:edit')")
//    public String addHotel(@ModelAttribute("hotel") @Valid Hotel hotel, BindingResult bindingResult, Model model) {
//
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("countries", hotelService.getAllCountries());
//            return "new-hotel";
//        }
//
//        if (hotelService.addHotel(hotel)) {
//            return "redirect:/management/manage";
//        } else {
//            String message = "Hotel already exists!";
//            model.addAttribute("message", message);
//            model.addAttribute("countries", hotelService.getAllCountries());
//            return "new-hotel";
//        }
//    }
//
//    @GetMapping("/addRoom")
////    @PreAuthorize("hasAuthority('developers:edit')")
//    public String newRoom(Model model) {
//        model.addAttribute("room", new Room());
//        model.addAttribute("hotels", hotelService.getAllHotels());
//        model.addAttribute("types", RoomsType.values());
//        return "new-room";
//    }
//
//    @PostMapping("/addRoom")
////    @PreAuthorize("hasAuthority('developers:edit')")
//    public String addRoom(@RequestParam String hotelName,
//                          @RequestParam String type,
//                          @RequestParam Integer number,
//                          @RequestParam Double price,
//                          Model model) {
//
//        Hotel hotel = hotelService.getHotelByName(hotelName);
//        Room room = Room.builder()
//                .hotel(hotel)
//                .type(RoomsType.valueOf(type))
//                .number(number)
//                .price(price)
//                .build();
//
//        if (roomService.addRoom(room)) {
//            return "redirect:/management/manage";
//        } else {
//            String message = "Room already exists!";
//            model.addAttribute("message", message);
//            model.addAttribute("hotels", hotelService.getAllHotels());
//            model.addAttribute("types", RoomsType.values());
//            return "new-room";
//        }
//    }
}
