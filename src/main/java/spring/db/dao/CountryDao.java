package spring.db.dao;

import spring.model.ioc.Country;

import java.util.List;

public interface CountryDao {

       String LOAD_COUNTRIES_SQL = "INSERT INTO country (name, code_name) VALUES ('%s', '%s')";

       String GET_ALL_COUNTRIES_SQL = "SELECT id, name, code_name FROM country";
       String GET_COUNTRIES_BY_NAME_SQL = "SELECT id, name, code_name FROM country WHERE name ='%s'";
       String GET_COUNTRY_BY_NAME_SQL = "SELECT id, name, code_name FROM country WHERE name = '%s'";
       String GET_COUNTRY_BY_CODE_NAME_SQL = "SELECT id, name, code_name FROM country WHERE code_name = '%s'";

       String UPDATE_COUNTRY_NAME_SQL = "UPDATE country SET name='%s' WHERE code_name='%s'";
       String UPDATE_COUNTRY_CODE_NAME_SQL = "UPDATE country SET code_name='%s' WHERE code_name='%s'";

       String DELETE_COUNTRY_BY_NAME_SQL = "DELETE FROM Country WHERE name='%s'";

    String[][] COUNTRY_INIT_DATA = {
              { "Australia", "AU" },
              { "Canada", "CA" },
              { "France", "FR" },
              { "Hong Kong", "HK" },
              { "Iceland", "IC" },
              { "Japan", "JP" },
              { "Nepal", "NP" },
              { "Russia", "RU" },
              { "Sweden", "SE" },
              { "Switzerland", "CH" },
              { "United Kingdom", "GB" },
              { "United States", "US" }
    };

     List<Country> getCountryList();
     List<Country> getCountryListStartWith(String name);

     void updateCountryCodeName(String codename, String newCountryCodeName);
     void loadCountries();
     void deleteCountryByName(String name);

     Country getCountryByCodeName(String codeName);
     Country getCountryByName(String name);
}
