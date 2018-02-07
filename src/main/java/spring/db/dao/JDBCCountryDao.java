package spring.db.dao;

import java.util.List;
import java.util.Map;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import spring.model.ioc.Country;
import spring.model.ioc.SimpleCountry;


public class JDBCCountryDao extends NamedParameterJdbcDaoSupport implements CountryDao {

	private static final RowMapper<Country> COUNTRY_ROW_MAPPER = (resultSet, i) ->
		new SimpleCountry(
				resultSet.getInt("id"),
				resultSet.getString("name"),
				resultSet.getString("code_name"));


	@Override
	public List<Country> getCountryList() {
		return getJdbcTemplate().query(GET_ALL_COUNTRIES_SQL, COUNTRY_ROW_MAPPER);
	}

	@Override
	public List<Country> getCountryListStartWith(String name) {
		return getNamedParameterJdbcTemplate().query(GET_COUNTRY_BY_NAME_SQL, new MapSqlParameterSource("name",
				name + "%" ), COUNTRY_ROW_MAPPER);
	}

	@Override
	public void updateCountryName(String codename, String newCountryCodeName) {

	}

	@Override
	public void loadCountries() {
		for (String [] countryData : COUNTRY_INIT_DATA) {
			getJdbcTemplate().execute(
					String.format(LOAD_COUNTRIES_SQL, countryData[0], countryData[1])
			);
		}
	}

	@Override
	public Country getCountryByCodeName(String codeName) {
		return getJdbcTemplate().query(String.format(GET_COUNTRY_BY_CODE_NAME_SQL, codeName),
                COUNTRY_ROW_MAPPER).get(0);
	}

	@Override
	public Country getCountryByName(String name) {
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		List<Country> countryList = jdbcTemplate.query(
		        String.format(GET_COUNTRIES_BY_NAME_SQL, name), COUNTRY_ROW_MAPPER);
		if (countryList.isEmpty()) {
		    throw new CountryNotFoundException("Country list is empty!");
        }
        return countryList.get(0);
	}
}
