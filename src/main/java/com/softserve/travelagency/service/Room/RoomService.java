package com.softserve.travelagency.service.Room;

import com.softserve.travelagency.model.Room;

import java.util.List;

public interface RoomService {

    List<Room> getRooms();
    void saveRoom(Room room);
    Room getRoom(Long id);
    void deleteRoom(Long id);
}
