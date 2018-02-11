package spring.model.ioc;

import lombok.Value;
import lombok.experimental.Wither;
import org.springframework.stereotype.Component;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;

@Value
@Component("person")
@javax.persistence.Entity
public class SimplePerson implements Person {

    @Id
    @GeneratedValue
    private int id;

    private String firstName;
    private String lastName;

    private boolean isProgrammer;
    @Wither
    private boolean isBroke;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
    private List<Contact> contacts;

}

