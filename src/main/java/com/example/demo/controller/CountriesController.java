package com.example.demo.controller;

import com.example.demo.model.Country;
import com.example.demo.repository.CountriesRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class CountriesController {
    CountriesRepository countriesRepository = new CountriesRepository();

    @GetMapping( path = "countries", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Country> get() {
        return countriesRepository.get();
    }

    @GetMapping(path = "countries/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Country get(@PathVariable Integer id) {
        return countriesRepository.get(id);
    }

    @PostMapping(path = "countries", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Country create(@RequestBody Country country){
        return countriesRepository.create(country);
    }

    @PutMapping(path = "countries/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Country update(@PathVariable Integer id, @RequestBody Country country){
        return countriesRepository.update(id, country);
    }

    @DeleteMapping(path = "countries/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Country delete(@PathVariable Integer id){
        return countriesRepository.delete(id);
    }
}
