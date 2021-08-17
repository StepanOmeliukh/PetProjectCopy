package com.softserve.travelagency.service.Hotel;

import com.softserve.travelagency.dao.Hotel.HotelDAO;
import com.softserve.travelagency.model.Country;
import com.softserve.travelagency.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelDAO hotelDAO;

    @Override
    @Transactional
    public List<Hotel> getHotels() {
        return hotelDAO.getHotels();
    }

    @Override
    @Transactional
    public void saveHotel(Hotel hotel) {
        hotelDAO.saveHotel(hotel);
    }

    @Override
    @Transactional
    public Hotel getHotel(Long id) {
        return hotelDAO.getHotel(id);
    }

    @Override
    @Transactional
    public void deleteHotel(Long id) {
        hotelDAO.deleteHotel(id);
    }

    @Override
    @Transactional
    public List<Hotel> findHotelByCountryName(String countryName) {
        return hotelDAO.findHotelByCountryName(countryName);
    }

    @Override
    @Transactional
    public Hotel getHotelByUsername(String username) {
        return hotelDAO.getHotelByUsername(username);
    }
}