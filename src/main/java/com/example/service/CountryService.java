package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Country;
import com.example.repository.CountryRepository;

@Service
public class CountryService {

	@Autowired
    private CountryRepository countryRepository;

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public Optional<Country> getCountryByName(String name) {
        return countryRepository.findById(name);
    }

    public Country saveCountry(Country country) {
        return countryRepository.save(country);
    }

    public void deleteCountry(String name) {
        countryRepository.deleteById(name);
    }

    public Country updateCountry(String name, Country countryDetails) {
        return countryRepository.findById(name).map(country -> {
            country.setAreaSqKm(countryDetails.getAreaSqKm());
            country.setPopulation(countryDetails.getPopulation());
            country.setContinent(countryDetails.getContinent());
            return countryRepository.save(country);
        }).orElseGet(() -> {
            countryDetails.setName(name);
            return countryRepository.save(countryDetails);
        });
    }
}
