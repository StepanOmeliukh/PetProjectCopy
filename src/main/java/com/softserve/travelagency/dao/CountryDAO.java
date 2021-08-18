package com.softserve.travelagency.dao;

import com.softserve.travelagency.model.Country;

import java.util.List;

public interface CountryDAO {

    List<Country> getCountries();
    void saveCountry(Country country);
    Country getCountry(Long id);
    void deleteCountry(Long id);
    Country getCountryByUsername(String username);
}
