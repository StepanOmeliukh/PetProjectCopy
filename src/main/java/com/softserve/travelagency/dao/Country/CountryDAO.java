package com.softserve.travelagency.dao.Country;

import com.softserve.travelagency.model.Country;

import java.util.List;
import java.util.Set;

public interface CountryDAO {

     List<Country> getCountries();
     void saveCountry(Country country);
     Country getCountry(Long id);
     void deleteCountry(Long id);
}
