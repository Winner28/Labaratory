package spring.database;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import spring.db.dao.CountryDao;
import spring.model.ioc.Country;
import spring.model.ioc.SimpleCountry;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:jdbc.xml")
public class JdbcTest {

    @Autowired
    private CountryDao countryDao;

    private List<Country> expectedCountryList = new ArrayList<>();
    private List<Country> expectedCountryListStartsWithA = new ArrayList<>();
    private final String COUNTRY_NAME = "Australia";
    private final String COUNTRY_CODE_NAME = "AU";
    private Country countryWithChangedName = new SimpleCountry(8, "Russia", "RU");

    @BeforeEach
    private void setUp() {
        initExpectedCountryList();
    }

    @Test
    @DirtiesContext
    void testThatExpectedCountriesAreNotEmpty() {
        assertFalse(expectedCountryList.isEmpty());
        assertFalse(expectedCountryListStartsWithA.isEmpty());
    }

    @Test
    @DirtiesContext
    void testThatWeCanGetExpectedCountryByName() {
        Country country = countryDao.getCountryByName(COUNTRY_NAME);
        assertEquals(country, getCountry());
    }

    private void initExpectedCountryList() {
        for (int i = 0; i < CountryDao.COUNTRY_INIT_DATA.length; i++) {
            String[] countryInitData = CountryDao.COUNTRY_INIT_DATA[i++];
            Country country = new SimpleCountry(i, countryInitData[0], countryInitData[1]);
            expectedCountryList.add(country);
            if (country.getName().startsWith("A")) {
                expectedCountryListStartsWithA.add(country);
            }
        }
    }


    private Country getCountry() {
        return new SimpleCountry(1,
                COUNTRY_NAME,
                COUNTRY_CODE_NAME);
    }
}
