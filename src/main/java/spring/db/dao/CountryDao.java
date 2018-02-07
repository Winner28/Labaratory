package spring.db.dao;

import spring.model.ioc.Country;

import java.util.List;

public interface CountryDao {

     static final String LOAD_COUNTRIES_SQL = "insert into country (name, code_name) values ";

     static final String GET_ALL_COUNTRIES_SQL = "select * from country";
     static final String GET_COUNTRIES_BY_NAME_SQL = "select * from country where name like :name";
     static final String GET_COUNTRY_BY_NAME_SQL = "select * from country where name = '";
     static final String GET_COUNTRY_BY_CODE_NAME_SQL = "select * from country where code_name = '";

     static final String UPDATE_COUNTRY_NAME_SQL_1 = "update country SET name='";
     static final String UPDATE_COUNTRY_NAME_SQL_2 = " where code_name='";

     static String[][] COUNTRY_INIT_DATA = {
            { "Australia", "AU" },
            { "Canada", "CA" },
            { "France", "FR" },
            { "Hong Kong", "HK" },
            { "Iceland", "IC" },
            { "Japan", "JP" }, { "Nepal", "NP" },
            { "Russian Federation", "RU" },
            { "Sweden", "SE" },
            { "Switzerland", "CH" },
            { "United Kingdom", "GB" },
            { "United States", "US" }
    };

     List<Country> getCountryList();
     List<Country> getCountryListStartWith(String name);

     void updateCountryName(String codename, String newCountryCodeName);
     void loadCountries();

     Country getCountryByCodeName(String codeName);
     Country getCountryByName(String name);
}
