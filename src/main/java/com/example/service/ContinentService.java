package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Continent;
import com.example.repository.ContinentRepository;

@Service
public class ContinentService {

	@Autowired
    private ContinentRepository continentRepository;

    public List<Continent> getAllContinents() {
        return continentRepository.findAll();
    }

    public Optional<Continent> getContinentById(String code) {
        return continentRepository.findById(code);
    }

    public Continent saveContinent(Continent continent) {
        return continentRepository.save(continent);
    }

    public void deleteContinent(String code) {
        continentRepository.deleteById(code);
    }

    public Continent updateContinent(String code, Continent continentDetails) {
        return continentRepository.findById(code).map(continent -> {
            continent.setName(continentDetails.getName());
            continent.setAreaSqKm(continentDetails.getAreaSqKm());
            continent.setPopulation(continentDetails.getPopulation());
            continent.setLines(continentDetails.getLines());
            continent.setCountries(continentDetails.getCountries());
            continent.setOceans(continentDetails.getOceans());
            continent.setDevelopedCountries(continentDetails.getDevelopedCountries());
            return continentRepository.save(continent);
        }).orElseGet(() -> {
            continentDetails.setCode(code);
            return continentRepository.save(continentDetails);
        });
    }
}
