package com.luxoft.springdb.lab3.dao;

import com.luxoft.springdb.lab3.model.Country;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class CountryDao extends JdbcDaoSupport {

    public static final String[][] COUNTRY_INIT_DATA = {{"Australia", "AU"},
            {"Canada", "CA"}, {"France", "FR"}, {"Hong Kong", "HK"},
            {"Iceland", "IC"}, {"Japan", "JP"}, {"Nepal", "NP"},
            {"Russian Federation", "RU"}, {"Sweden", "SE"},
            {"Switzerland", "CH"}, {"United Kingdom", "GB"},
            {"United States", "US"}};

    private static final CountryRowMapper COUNTRY_ROW_MAPPER = new CountryRowMapper();

    public List<Country> getCountryList() {
        return getJdbcTemplate().query("select * from country", COUNTRY_ROW_MAPPER);
    }

    public List<Country> getCountryListStartWith(String name) {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("name", name + "%");
        return namedParameterJdbcTemplate
                .query("select * from country where name like :name", sqlParameterSource, COUNTRY_ROW_MAPPER);
    }

    public void updateCountryName(String codeName, String newCountryName) {
        getJdbcTemplate().update("update country SET name= ? where code_name= ?", newCountryName, codeName);
    }

    public Country getCountryByCodeName(String codeName) {
        return getJdbcTemplate().query("select * from country where code_name = ?", COUNTRY_ROW_MAPPER, codeName).get(0);
    }

    public Country getCountryByName(String name) throws CountryNotFoundException {
        List<Country> countryList = getJdbcTemplate().query("select * from country where name = ?", COUNTRY_ROW_MAPPER, name);

        if (countryList.isEmpty()) {
            throw new CountryNotFoundException();
        }
        return countryList.get(0);
    }
}
