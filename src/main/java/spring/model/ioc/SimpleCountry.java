package spring.model.ioc;

import lombok.Value;

@Value
public class SimpleCountry implements Country {
    private String name;
    private String codeName;
}