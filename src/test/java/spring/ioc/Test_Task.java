package spring.ioc;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import spring.model.ioc.Contact;
import spring.model.ioc.Country;
import spring.model.ioc.Person;
import spring.model.ioc.SimpleContact;
import spring.model.ioc.SimpleCountry;
import spring.model.ioc.SimplePerson;

import java.util.Collections;


import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:ioc.xml")
@AllArgsConstructor(onConstructor = @__(@Autowired))
class Test_Task {
    Person person;
    Country country;
    Contact contact;

    @Test
    void testThatWeCanGetExpectedCountry() {
        assertEquals(country, getExpectedCountry());
    }

    @Test
    void testThatWeCanGetExpectedContacts() {
        assertEquals(contact, getExpectedContact());
    }

    @Test
    void testThatWeCanGetExpectedPerson() {
        assertEquals(person, getExpectedPerson());
    }

    private Person getExpectedPerson() {
        return new SimplePerson("Makar",
                "Fedor",
                true,
                false,
                getExpectedCountry(),
                Collections.singletonList(getExpectedContact()));
    }

    private Country getExpectedCountry() {
        return new SimpleCountry(1L,
                "Belarus",
                "BY");
    }

    private Contact getExpectedContact() {
        return new SimpleContact("@epam.com",
                "3223222");
    }
}
