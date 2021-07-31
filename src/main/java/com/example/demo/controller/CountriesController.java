package com.example.demo.controller;

import com.example.demo.model.Country;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
public class CountriesController {
    List<Country> countries = new ArrayList<>();

    @GetMapping( path = "countries", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Country> get() {
        return countries;
    }

    @GetMapping(path = "countries/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Country get(@PathVariable Integer id) {
        return getCountryById(id);
    }

    @PostMapping(path = "countries", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Country create(@RequestBody Country country){
        Country newCountry = new Country(country.getName());
        countries.add(newCountry);
        return newCountry;
    }
    @PutMapping(path = "countries/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Country update(@PathVariable Integer id, @RequestBody Country country){
        country.setId(id);
        countries.set(countries.indexOf(getCountryById(id)), country);
        return country;
    }

    private Country getCountryById(Integer id){
        return countries.stream().filter(el -> el.getId().equals(id)).findFirst().get();
    }
}
