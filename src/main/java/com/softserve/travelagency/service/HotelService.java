package com.softserve.travelagency.service;

import com.softserve.travelagency.model.Country;
import com.softserve.travelagency.model.Hotel;

import java.util.List;

public interface HotelService {

    List<Hotel> getHotels();
    void saveHotel(Hotel hotel);
    Hotel getHotel(Long id);
    void deleteHotel(Long id);
    List<Hotel> findHotelByCountryName(String countryName);
    Hotel getHotelByUsername(String username);
}
