package spring.model.ioc;

import lombok.Value;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Value
public class SimpleCountry implements Country {

    public SimpleCountry() {

    }
    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)*/
    private int id;

   // @Column(name = "name")
    private String name;

   // @Column(name = "code_name")
    private String codeName;
}
