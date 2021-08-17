package com.softserve.travelagency.service.Room;

import com.softserve.travelagency.dao.Room.RoomDAO;
import com.softserve.travelagency.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService{

    @Autowired
    private RoomDAO roomDAO;

    @Override
    @Transactional
    public List<Room> getRooms() {
        return roomDAO.getRooms();
    }

    @Override
    @Transactional
    public void saveRoom(Room room) {
        roomDAO.saveRoom(room);
    }

    @Override
    @Transactional
    public Room getRoom(Long id) {
        return roomDAO.getRoom(id);
    }

    @Override
    @Transactional
    public void deleteRoom(Long id) {
        roomDAO.deleteRoom(id);
    }
}
