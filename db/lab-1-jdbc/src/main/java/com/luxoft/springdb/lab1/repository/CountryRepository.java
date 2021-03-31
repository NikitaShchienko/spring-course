package com.luxoft.springdb.lab1.repository;

import com.luxoft.springdb.lab1.model.Country;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CountryRepository extends MongoRepository<Country, Integer> {

    @Override
    List<Country> findAll();

    @Override
    Optional<Country> findById(Integer integer);

    Optional<Country> findByCodeName(String codName);
}
