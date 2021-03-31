package com.luxoft.springdb.lab1;

import com.luxoft.springdb.lab1.model.Country;
import com.luxoft.springdb.lab1.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import javax.annotation.PostConstruct;

@EnableMongoRepositories
@SpringBootApplication
public class Main {

    @Autowired
    protected CountryRepository countryRepository;

    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }


    @PostConstruct
    public void init() {
        countryRepository.save(new Country(0, "Australia", "AU"));
        countryRepository.save(new Country(1, "Canada", "CA"));
        countryRepository.save(new Country(2, "France", "FR"));
        countryRepository.save(new Country(3, "Hong Kong", "HK"));
        countryRepository.save(new Country(4, "Iceland", "IC"));
        countryRepository.save(new Country(5, "Japan", "JP"));
        countryRepository.save(new Country(6, "Nepal", "NP"));
        countryRepository.save(new Country(7, "Russian Federation", "RU"));
        countryRepository.save(new Country(8, "Sweden", "SE"));
        countryRepository.save(new Country(9, "Switzerland", "CH"));
        countryRepository.save(new Country(10, "United Kingdom", "GB"));
        countryRepository.save(new Country(11, "United States", "US"));
    }
}
