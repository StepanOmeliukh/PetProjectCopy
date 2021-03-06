package com.softserve.travelagency.service;

import com.softserve.travelagency.model.Room;

import java.util.List;

public interface RoomService {

    List<Room> getRooms();
    void saveRoom(Room room);
    Room getRoom(Long id);
    void deleteRoom(Long id);
    List<Room> getRoomsByParams(String countryName, String roomType, String stars, boolean cleaning);
}
