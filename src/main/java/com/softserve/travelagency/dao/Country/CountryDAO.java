package com.softserve.travelagency.dao.Country;

import com.softserve.travelagency.model.Country;

import java.util.List;

public interface CountryDAO {

    public List<Country> getCountries();
    public void saveCountry(Country country);
    public Country getCountry(Long id);
    public void deleteCountry(Long id);
}
