package com.zekerijah.fleetmanagement.service;

import com.zekerijah.fleetmanagement.model.Country;
import com.zekerijah.fleetmanagement.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getCountries(){
        return countryRepository.findAll();
    }

    public void saveCountry(Country country){
        countryRepository.save(country);
    }

    public Optional<Country> getCountryById(Integer id){
        return countryRepository.findById(id);
    }


}
