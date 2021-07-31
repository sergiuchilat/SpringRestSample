package com.example.demo.controller;

import com.example.demo.model.Country;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


@RestController
public class CountriesController {
    List<Country> countries = Arrays.asList(
            new Country("Moldova"),
            new Country("Romania")
    );

    @GetMapping( path = "countries", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Country> get() {
        return countries;
    }

    @GetMapping(path = "countries/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Country get(@PathVariable Integer id) {
        return countries.stream().filter(el -> el.getId().equals(id)).findFirst().get();
    }

    @PostMapping(path = "countries", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Country create(@RequestBody Country country){
        System.out.println(country);
        /*System.out.println(country.toString());
        Country newCountry = new Country(country.getName());
        countries.add(newCountry);*/
        return null;
    }
    @PutMapping(path = "countries/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Country update(@PathVariable Integer id, @RequestBody Country country){
        countries.set(0, country);
        return country;
    }
}
