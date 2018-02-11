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
		return getJdbcTemplate().query(String.format(GET_COUNTRY_BY_NAME_SQL, name), COUNTRY_ROW_MAPPER);
	}

	@Override
	public void updateCountryCodeName(String codename, String newCountryCodeName) {
	    getJdbcTemplate().execute(
	            String.format(UPDATE_COUNTRY_CODE_NAME_SQL, newCountryCodeName, codename));
	}

	@Override
	public void updateCountryName(String oldName, String newCountryName) {
		getJdbcTemplate().execute(
				String.format(UPDATE_COUNTRY_NAME_SQL, newCountryName, oldName)
		);
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
    public void deleteCountryByName(String name) {
	    getJdbcTemplate().execute(String.format(DELETE_COUNTRY_BY_NAME_SQL, name));
    }

    @Override
    public Country getCountryByCodeName(String codeName) {
        JdbcTemplate jdbcTemplate = getJdbcTemplate();
        String sql = String.format(GET_COUNTRY_BY_CODE_NAME_SQL, codeName);
        return jdbcTemplate.queryForObject(sql, COUNTRY_ROW_MAPPER);
    }

    @Override
    public Country getCountryByName(String name)
            throws CountryNotFoundException {
        JdbcTemplate jdbcTemplate = getJdbcTemplate();
        List<Country> countryList = jdbcTemplate.query(
                String.format(GET_COUNTRY_BY_NAME_SQL,name),
                COUNTRY_ROW_MAPPER);
        if (countryList.isEmpty()) {
            throw new CountryNotFoundException("Country list is epmty!");
        }
        return countryList.get(0);
    }

	@Override
	public void save(Country country) {

	}
}
