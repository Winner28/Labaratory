package spring.model.ioc;

import lombok.NoArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Value
public class SimplePerson implements Person {
    private String firstName;
    private String lastName;
    private boolean isProgrammer;
    private boolean isBroke;
    private Country country;
    private List<Contact> contacts;

}

