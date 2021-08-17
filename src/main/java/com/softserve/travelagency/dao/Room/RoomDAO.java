package com.softserve.travelagency.dao.Room;

import com.softserve.travelagency.model.Country;
import com.softserve.travelagency.model.Room;

import java.util.List;

public interface RoomDAO {

    List<Room> getRooms();
    void saveRoom(Room room);
    Room getRoom(Long id);
    void deleteRoom(Long id);
}
