package com.luxoft.springdb.lab1.controller;

import com.luxoft.springdb.lab1.model.Country;
import com.luxoft.springdb.lab1.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class CountryController {

    @Autowired
    protected CountryRepository countryRepository;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/country/all")
    public List<Country> getCountryAll() {
        return countryRepository.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/country/{id}")
    public Country getCountryById(@PathVariable String id) {
        return countryRepository.findById(Integer.valueOf(id)).orElse(null);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/country/filter")
    public Country getCountryByCodeName(@RequestParam String code) {
        return countryRepository.findByCodeName(code).orElse(null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/country")
    public Country create(@RequestBody Country country) {
        return countryRepository.save(country);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/country")
    public Country update(@RequestBody Country country) {
        return countryRepository.save(country);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/country")
    public void delete(@RequestParam String id) {
        Country country = countryRepository.findById(Integer.valueOf(id)).orElse(null);
        countryRepository.delete(country);
    }

}
