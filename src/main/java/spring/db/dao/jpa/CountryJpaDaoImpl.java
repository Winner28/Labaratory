package spring.db.dao.jpa;

import org.springframework.stereotype.Repository;
import spring.db.dao.CountryDao;
import spring.model.ioc.Country;

import javax.persistence.EntityManager;
import java.util.List;

@Repository("countryJpaDao")
public class CountryJpaDaoImpl extends AbstractJpaDao implements CountryDao {

    public Country save(Country country) {
        return mapEntityManagerInTransaction(entityManager ->
            entityManager.merge(country));
    }



    @Override
    public List<Country> getCountryList() {
        return mapEntityManager(entityManager -> entityManager.createQuery(
                "select c from SimpleCountry c", Country.class)
                .getResultList());
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
