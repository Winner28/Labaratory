package spring.db.dao.jpa;

import org.springframework.stereotype.Repository;
import spring.db.dao.CountryDao;
import spring.model.ioc.Country;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CountryJpaDaoImpl extends AbstractJpaDao implements CountryDao {

    public void save(Country country) {
        EntityManager em = emf.createEntityManager();
        if (em == null) {
            emf.close();
            throw new RuntimeException("Smth went wrong");
        }
        em.persist(country);
    }



    @Override
    public List<Country> getCountryList() {
        return null;
    }

    @Override
    public List<Country> getCountryListStartWith(String name) {
        return null;
    }

    @Override
    public void updateCountryCodeName(String codename, String newCountryCodeName) {

    }

    @Override
    public void updateCountryName(String oldName, String newCountryName) {

    }

    @Override
    public void loadCountries() {

    }

    @Override
    public void deleteCountryByName(String name) {

    }

    @Override
    public Country getCountryByCodeName(String codeName) {
        return null;
    }

    @Override
    public Country getCountryByName(String name) {
        return null;
    }
}
