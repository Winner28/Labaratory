package spring.model.ioc;

import lombok.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Value
@Component("person")
public class SimplePerson implements Person {
    private String firstName;
    private String lastName;
    private boolean isProgrammer;
    private boolean isBroke;
    private Country country;
    private List<Contact> contacts;

}

