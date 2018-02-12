package spring.orm;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import spring.db.dao.CountryDao;
import spring.model.ioc.Country;
import spring.model.ioc.SimpleCountry;

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

    @Test
    void testSaveCountry() {
        countryJpaDao.save(getCountryForSave());
        List<Country> countryList = countryJpaDao.getCountryList();
        assertEquals(getCountryForSave(), countryList.get(0));
    }

    private Country getCountryForSave() {
        return new SimpleCountry(1L,
                COUNTRY_NAME_FOR_SAVE,
                COUNTRY_CODE_NAME_FOR_SAVE);
    }
}
