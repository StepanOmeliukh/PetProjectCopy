package com.softserve.travelagency.service.Hotel;

import com.softserve.travelagency.model.Hotel;

import java.util.List;

public interface HotelService {

    public List<Hotel> getHotels();
    public void saveHotel(Hotel hotel);
    public Hotel getHotel(Long id);
    public void deleteHotel(Long id);
}
