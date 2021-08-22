package com.softserve.travelagency.service.impl;

import com.softserve.travelagency.dao.BookingDAO;
import com.softserve.travelagency.model.Booking;
import com.softserve.travelagency.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingDAO bookingDAO;

    @Override
    @Transactional
    public List<Booking> getBookings() {
        return bookingDAO.getBookings();
    }

    @Override
    @Transactional
    public void saveBooking(Booking booking) {
        bookingDAO.saveBooking(booking);
    }

    @Override
    @Transactional
    public Booking getBooking(Long id) {
        return bookingDAO.getBooking(id);
    }

    @Override
    @Transactional
    public void deleteBooking(Long id) {
        bookingDAO.deleteBooking(id);
    }

    @Override
    public List<Booking> getBookingByDate(LocalDate enter, LocalDate departure, String countryName, String roomType, String stars, boolean cleaning) {
        return bookingDAO.getBookingByDate(enter, departure, countryName, roomType, stars, cleaning);
    }
}
