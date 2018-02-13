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
        //TODO
        // not needed
        return null;
    }

    @Override
    public void updateCountryCodeName(String codename, String newCountryCodeName) {
        withEntityManagerInTransaction(entityManager ->
                entityManager.createQuery(
                        "update SimpleCountry set codeName = :newCodeName " +
                                "where codeName = :oldCodeName")
                        .setParameter("newCodeName", newCountryCodeName)
                        .setParameter("oldCodeName", codename));
    }

    @Override
    public void updateCountryName(String oldName, String newCountryName) {
         withEntityManagerInTransaction(entityManager -> {
            entityManager.createQuery(
                    "update SimpleCountry set name = :newName " +
                            "where name = :oldName")
                    .setParameter("newName", newCountryName)
                    .setParameter("oldName", oldName);
            entityManager.flush();
         });


    }

    @Override
    public void loadCountries() {
        //TODO
        // not needed
    }

    @Override
    public void deleteCountryByName(String name) {
        withEntityManagerInTransaction(entityManager -> {
            entityManager.createQuery("delete from SimpleCountry where name = :name")
                    .setParameter("name", name);
            entityManager.flush();
        });
    }

    @Override
    public Country getCountryByCodeName(String codeName) {
        return mapEntityManager(entityManager ->
                entityManager.createQuery(
                        "select c from SimpleCountry c where c.codeName like :codeName",
                        Country.class)
                        .setParameter("codeName", codeName)
                        .getSingleResult());
    }

    @Override
    public Country getCountryByName(String name) {
        return mapEntityManager(entityManager ->
            entityManager.createQuery(
                    "select c from SimpleCountry c where c.name like :name",
                    Country.class)
                    .setParameter("name", name)
                    .getSingleResult());
    }
}
