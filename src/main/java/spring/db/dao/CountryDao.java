package spring.db.dao;

import java.util.List;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;


public class CountryDao extends JdbcDaoSupport {
	private static final String LOAD_COUNTRIES_SQL = "insert into country (name, code_name) values ";

	private static final String GET_ALL_COUNTRIES_SQL = "select * from country";
	private static final String GET_COUNTRIES_BY_NAME_SQL = "select * from country where name like :name";
	private static final String GET_COUNTRY_BY_NAME_SQL = "select * from country where name = '";
	private static final String GET_COUNTRY_BY_CODE_NAME_SQL = "select * from country where code_name = '";

	private static final String UPDATE_COUNTRY_NAME_SQL_1 = "update country SET name='";
	private static final String UPDATE_COUNTRY_NAME_SQL_2 = " where code_name='";

	public static final String[][] COUNTRY_INIT_DATA = {
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


}
