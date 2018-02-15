package spring.service;

import java.util.List;


import org.springframework.transaction.annotation.Propagation;
import spring.model.ioc.Country;

public interface CountryService {

    public List<Country> getAllCountriesInsideTransaction(Propagation propagation);

    public List<Country> getAllCountriesRequired();

    public List<Country> getAllCountriesRequiresNew();

    public List<Country> getAllCountriesSupports();

    public List<Country> getAllCountriesNever();

    public List<Country> getAllCountriesMandatory();

    public List<Country> getAllCountriesNotSupported();

    public List<Country> getAllCountries();
}
