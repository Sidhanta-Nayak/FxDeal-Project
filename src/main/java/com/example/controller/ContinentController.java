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

import com.example.entity.Continent;
import com.example.service.ContinentService;

@RestController
@RequestMapping("/api/continents")
public class ContinentController {

	@Autowired
    private ContinentService continentService;

    @GetMapping
    public List<Continent> getAllContinents() {
        return continentService.getAllContinents();
    }

    @GetMapping("/{code}")
    public ResponseEntity<Continent> getContinentByCode(@PathVariable String code) {
        Optional<Continent> continent = continentService.getContinentById(code);
        return continent.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Continent createContinent(@RequestBody Continent continent) {
        return continentService.saveContinent(continent);
    }

    @PutMapping("/{code}")
    public ResponseEntity<Continent> updateContinent(@PathVariable String code, @RequestBody Continent continentDetails) {
        Continent updatedContinent = continentService.updateContinent(code, continentDetails);
        return ResponseEntity.ok(updatedContinent);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deleteContinent(@PathVariable String code) {
        continentService.deleteContinent(code);
        return ResponseEntity.noContent().build();
    }
}
