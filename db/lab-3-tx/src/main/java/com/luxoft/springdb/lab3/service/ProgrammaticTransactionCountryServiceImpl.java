package com.luxoft.springdb.lab3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionTemplate;

import com.luxoft.springdb.lab3.dao.CountryDao;
import com.luxoft.springdb.lab3.dao.CountryNotFoundException;
import com.luxoft.springdb.lab3.model.Country;

import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;

import java.util.List;

@Repository
public class ProgrammaticTransactionCountryServiceImpl implements ProgrammaticTransactionCountryService {
    private TransactionTemplate transactionTemplate;
    private CountryDao countryDao;

    @Autowired
    public ProgrammaticTransactionCountryServiceImpl(PlatformTransactionManager transactionManager, CountryDao countryDao) {
        this.transactionTemplate = new TransactionTemplate(transactionManager);
        this.countryDao = countryDao;
    }

    public Country getCountryByName(final String name) {
        transactionTemplate.setIsolationLevel(Isolation.REPEATABLE_READ.value());
        return (Country) transactionTemplate.execute((TransactionCallback<Object>) status -> {
            try {
                return countryDao.getCountryByName(name);
            } catch (CountryNotFoundException e) {
                return null;
            }
        });
    }

    public Country getCountryByCodeName(final String codeName, final Propagation propagation) {
        return (Country) transactionTemplate.execute((TransactionCallback<Object>) status -> getCountryByCodeNameInTransaction(codeName, propagation));
    }

    private Country getCountryByCodeNameInTransaction(final String codeName, final Propagation propagation) {

        return (Country) transactionTemplate.execute((TransactionCallback<Object>) status -> {
            TransactionLog.append("Method inside transaction, propagation = " + propagation.toString() + "\n");
            return countryDao.getCountryByCodeName(codeName);
        });
    }


    public List<Country> getAllCountries() {
        return countryDao.getCountryList();
    }

    public CountryDao getCountryDao() {
        return countryDao;
    }

    public void setCountryDao(CountryDao countryDao) {
        this.countryDao = countryDao;
    }
}
