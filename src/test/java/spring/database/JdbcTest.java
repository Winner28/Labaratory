package spring.database;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import spring.db.dao.CountryDao;
import spring.db.dao.CountryNotFoundException;
import spring.model.ioc.Country;
import spring.model.ioc.SimpleCountry;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:jdbc.xml")
public class JdbcTest {

    @Autowired
    private CountryDao countryDao;

    private List<Country> expectedCountryList = new ArrayList<>();
    private static final String COUNTRY_NAME = "Australia";
    private static final String COUNTRY_CODE_NAME = "AU";
    private static final String NEW_COUNTRY_CODE_NAME = "AUS";
    private static final String SECOND_COUNTRY_NAME = "Argentine";
    private static final String SECOND_COUNTRY_CODE_NAME = "AR";
    private static final String BEST_COUNTRY_NAME = "Belarus";
    private static final String BEST_COUNTRY_CODE_NAME = "BY";
    private static final String COUNTRY_NAME_FOR_UPDATE = "Armenia";


    @BeforeEach
    private void setUp() {
        initExpectedCountryList();
    }

    @Test
    @DirtiesContext
    void testThatExpectedCountriesAreNotEmpty() {
        assertFalse(expectedCountryList.isEmpty());
    }

    @Test
    @DirtiesContext
    void testThatWeCanGetExpectedCountryByName() {
        Country country = countryDao.getCountryByName(BEST_COUNTRY_NAME);
        assertEquals(country, getCountry());
    }

    @Test
    @DirtiesContext
    void testThatWeCanGetExpectedCountryByCodeName() {
        Country country = countryDao.getCountryByCodeName(BEST_COUNTRY_CODE_NAME);
        assertEquals(country, getCountry());
    }

    @Test
    @DirtiesContext
    void testThatWeCanUpdateCountryCodeName() {
        Country beforeUpdate = countryDao.getCountryByName(COUNTRY_NAME);
        countryDao.updateCountryCodeName(COUNTRY_CODE_NAME, NEW_COUNTRY_CODE_NAME);
        Country afterUpdate = countryDao.getCountryByName(COUNTRY_NAME);
        assertNotEquals(beforeUpdate, afterUpdate);
    }

    @Test
    @DirtiesContext
    void testThatWeCanUpdateCountryName() {
        Country beforeUpdate = countryDao.getCountryByCodeName(SECOND_COUNTRY_CODE_NAME);
        countryDao.updateCountryName(SECOND_COUNTRY_NAME, COUNTRY_NAME_FOR_UPDATE);
        Country afterUpdate = countryDao.getCountryByCodeName(SECOND_COUNTRY_CODE_NAME);
        assertNotEquals(beforeUpdate, afterUpdate);
        String newCountryName = afterUpdate.getName();
        assertEquals(newCountryName, COUNTRY_NAME_FOR_UPDATE);
    }

    @Test
    @DirtiesContext
    void testThatWeCanDeleteCountryByCountryName() {
        int countrySizeBeforeDelete = expectedCountryList.size();
        countryDao.deleteCountryByName(COUNTRY_NAME);
        int countrySizeAfterDelete = countryDao.getCountryList().size();
        assertThat(countrySizeBeforeDelete, greaterThan(countrySizeAfterDelete));
    }

    @Test
    @DirtiesContext
    void testExpectionThrowsAfterTryingToGetDeletedCountry() {
        countryDao.deleteCountryByName(SECOND_COUNTRY_NAME);
        assertThrows(CountryNotFoundException.class, () -> countryDao.getCountryByName(SECOND_COUNTRY_NAME));
    }

    private void initExpectedCountryList() {
        expectedCountryList = countryDao.getCountryList();
    }

    private Country getCountry() {
        return new SimpleCountry(2L,
                BEST_COUNTRY_NAME,
                BEST_COUNTRY_CODE_NAME);
    }
}
