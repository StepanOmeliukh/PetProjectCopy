package com.softserve.travelagency.service;

import com.softserve.travelagency.model.Booking;

import java.time.LocalDate;
import java.util.List;

public interface BookingSrvice {

    List<Booking> getBookings();
    void saveBooking(Booking booking);
    Booking getBooking(Long id);
    void deleteBooking(Long id);
    List<Booking> getBookingByDate(LocalDate enter, LocalDate departure, String countryName, String roomType, String stars, boolean cleaning);
}
