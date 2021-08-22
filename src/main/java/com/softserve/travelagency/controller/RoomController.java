package com.softserve.travelagency.controller;

import com.softserve.travelagency.model.Hotel;
import com.softserve.travelagency.model.Room;
import com.softserve.travelagency.service.HotelService;
import com.softserve.travelagency.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/room")
public class RoomController {

    @Autowired
    private RoomService roomService;
    @Autowired
    private HotelService hotelService;

    @PostMapping("/save")
    public String saveRoom(Room room, Hotel hotel){
//        room.setBooked(false);
        Hotel hotelResult = hotelService.getHotelByUsername(hotel.getHotelName());
        room.setHotel(hotelResult);

        roomService.saveRoom(room);
        return "redirect:/admin/list";
    }
}
