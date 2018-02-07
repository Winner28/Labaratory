package spring.database;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import spring.db.dao.CountryDao;
import spring.model.ioc.Country;
import spring.model.ioc.SimpleCountry;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:jdbc.xml")
public class JdbcTest {

    @Autowired
    private CountryDao countryDao;

    private List<Country> expectedCountryList = new ArrayList<>();
    private List<Country> expectedCountryListStartsWithR = new ArrayList<>();
    private Country countryWithChangedName = new SimpleCountry(8, "Russia", "RU");

    private void initExpectedCountryList() {
        for (int i = 0; i < CountryDao.COUNTRY_INIT_DATA.length; i++) {
            String[] countryInitData = CountryDao.COUNTRY_INIT_DATA[i++];
            Country country = new SimpleCountry(i, countryInitData[0], countryInitData[1]);
            expectedCountryList.add(country);
            if (country.getName().startsWith("R")) {
                expectedCountryListStartsWithR.add(country);
            }
        }
    }
}
