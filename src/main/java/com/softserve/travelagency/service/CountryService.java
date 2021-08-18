package com.softserve.travelagency.service;

import com.softserve.travelagency.model.Country;

import java.util.List;

public interface CountryService {

    List<Country> getCountries();
    void saveCountry(Country country);
    Country getCountry(Long id);
    void deleteCountry(Long id);
    Country getCountryByUsername(String username);
}
