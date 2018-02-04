package spring;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

import java.util.List;

@Value
public class SimplePerson implements Person {
    private String firstName;
    private String lastName;
    private boolean isProgrammer;
    private Country country;
    private List<Contact> contacts;

}

