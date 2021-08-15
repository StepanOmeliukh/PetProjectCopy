package com.softserve.travelagency.dao.Hotel;

import com.softserve.travelagency.model.Country;
import com.softserve.travelagency.model.Hotel;

import java.util.List;

public interface HotelDAO {

    public List<Hotel> getHotels();
    public void saveHotel(Hotel hotel);
    public Hotel getHotel(Long id);
    public void deleteHotel(Long id);
}
