package com.example.entity;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Continent {

	@Id
    private String code;

    private String name;
    private long areaSqKm;
    private long population;

    @ElementCollection
    private List<String> lines;

    private int countries;

    @ElementCollection
    private List<String> oceans;

    @ElementCollection
    private List<String> developedCountries;
}
