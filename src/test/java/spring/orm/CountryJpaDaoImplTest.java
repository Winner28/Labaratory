package spring.orm;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import spring.db.dao.CountryDao;
import spring.db.dao.jpa.CountryJpaDaoImpl;
import spring.model.ioc.Country;
import spring.model.ioc.SimpleCountry;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:orm.xml")
public class CountryJpaDaoImplTest {

    @Autowired
    private CountryDao countryJpaDao;

    @Test
    void testSaveCountry() {
        countryJpaDao.save(getSimpleCountry());
    }

    private Country getSimpleCountry() {
        return new SimpleCountry(1,
                "Russia",
                "RU");
    }
}
