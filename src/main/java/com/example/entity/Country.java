package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Country {

	@Id
    private String name;

    private long population;
    private long areaSqKm;

    @ManyToOne
    private Continent continent;
}
