package com.example.demo.repository;

import com.example.demo.model.Country;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

public class CountriesRepository {
    List<Country> countries = new ArrayList<>();

    public List<Country> get() {
        return countries;
    }

    public Country get(Integer id) {
        return getCountryById(id);
    }

    public Country create(Country country){
        Country newCountry = new Country(country.getName());
        countries.add(newCountry);
        return newCountry;
    }

    public Country update(Integer id, Country country){
        country.setId(id);
        countries.set(countries.indexOf(getCountryById(id)), country);
        return country;
    }

    public Country delete(Integer id){
        Country countryToDelete = getCountryById(id);
        countries.remove(countryToDelete);
        return countryToDelete;
    }

    private Country getCountryById(Integer id){
        return countries.stream().filter(el -> el.getId().equals(id)).findFirst().get();
    }
}
