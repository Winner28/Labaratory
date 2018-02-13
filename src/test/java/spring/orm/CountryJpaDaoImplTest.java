package spring.orm;

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
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:orm.xml")
class CountryJpaDaoImplTest {

    @Autowired
    private CountryDao countryJpaDao;

    private static final String COUNTRY_NAME_FOR_SAVE = "Russia";
    private static final String COUNTRY_CODE_NAME_FOR_SAVE = "RU";

    private static final String BEST_COUNTRY_NAME = "Belarus";
    private static final String BEST_COUNTRY_CODE_NAME = "BLR";

    private static final String ONE_MORE_COUNTRY_NAME = "Australia";
    private static final String ONE_MORE_COUNTRY_CODE_NAME = "AU";

    @Test
    @DirtiesContext
    void testSaveCountry() {
        countryJpaDao.save(getCountryForSave());
        List<Country> countryList = countryJpaDao.getCountryList();
        assertEquals(getCountryForSave(), countryList.get(0));
    }

    @Test
    @DirtiesContext
    void testThatWeCanGetExpectedCountryByName() {
        countryJpaDao.save(getOneMoreCountry());
        assertEquals(countryJpaDao.getCountryByName(ONE_MORE_COUNTRY_NAME),
                getOneMoreCountry());
    }

    @Test
    @DirtiesContext
    void testThatWeCanGetExpectedCountryByCodeName() {
        countryJpaDao.save(getOneMoreCountry());
        assertEquals(countryJpaDao.getCountryByCodeName(ONE_MORE_COUNTRY_CODE_NAME),
                getOneMoreCountry());
    }

    @Test
    @DirtiesContext
    void testThatWeCanUpdateCountryNameAndCodeName() {
        countryJpaDao.save(getCountryForSave());
        countryJpaDao.updateCountryName(COUNTRY_NAME_FOR_SAVE, BEST_COUNTRY_NAME);
        countryJpaDao.updateCountryCodeName(COUNTRY_CODE_NAME_FOR_SAVE, BEST_COUNTRY_CODE_NAME);
        assertEquals(getBestCountryInDaUniverse(), countryJpaDao.getCountryList().get(0));
    }

    @Test
    @DirtiesContext
    void testThatWeCanDeleteCountryByName() {
        countryJpaDao.save(getCountryForSave());
        assertThat(countryJpaDao.getCountryList().size(), greaterThan(0));
        countryJpaDao.deleteCountryByName(COUNTRY_NAME_FOR_SAVE);
        assertThat(countryJpaDao.getCountryList().size(), is(0));
    }

    private Country getCountryForSave() {
        return new SimpleCountry(1L,
                COUNTRY_NAME_FOR_SAVE,
                COUNTRY_CODE_NAME_FOR_SAVE);
    }

    private Country getOneMoreCountry() {
        return new SimpleCountry(1L,
                ONE_MORE_COUNTRY_NAME,
                ONE_MORE_COUNTRY_CODE_NAME);
    }

    private Country getBestCountryInDaUniverse() {
        return new SimpleCountry(1L,
                BEST_COUNTRY_NAME,
                BEST_COUNTRY_CODE_NAME);
    }
}
