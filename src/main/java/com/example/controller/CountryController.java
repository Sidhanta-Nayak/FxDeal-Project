package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Country;
import com.example.service.CountryService;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

	@Autowired
    private CountryService countryService;

    @GetMapping
    public List<Country> getAllCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping("/{name}")
    public ResponseEntity<Country> getCountryByName(@PathVariable String name) {
        Optional<Country> country = countryService.getCountryByName(name);
        return country.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Country createCountry(@RequestBody Country country) {
        return countryService.saveCountry(country);
    }

    @PutMapping("/{name}")
    public ResponseEntity<Country> updateCountry(@PathVariable String name, @RequestBody Country countryDetails) {
        Country updatedCountry = countryService.updateCountry(name, countryDetails);
        return ResponseEntity.ok(updatedCountry);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteCountry(@PathVariable String name) {
        countryService.deleteCountry(name);
        return ResponseEntity.noContent().build();
    }
}
