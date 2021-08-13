package com.softserve.travelagency.service.Country;

import com.softserve.travelagency.dao.Country.CountryDAO;
import com.softserve.travelagency.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryDAO countryDAO;

    @Override
    @Transactional
    public List<Country> getCountries() {
        return countryDAO.getCountries();
    }

    @Override
    @Transactional
    public void saveCountry(Country country) {
        countryDAO.saveCountry(country);
    }

    @Override
    @Transactional
    public Country getCountry(Long id) {
        return countryDAO.getCountry(id);
    }

    @Override
    @Transactional
    public void deleteCountry(Long id) {
        countryDAO.deleteCountry(id);
    }
}