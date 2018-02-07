package spring.aop;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import spring.Tests;
import spring.model.bar.Bar;
import spring.model.bar.CustomerBrokenException;
import spring.model.ioc.Person;

import static org.springframework.test.util.AssertionErrors.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:aop.xml")
class AopAspectJExceptionTest {

    @Autowired
    Person aopPerson;

    @Autowired
    Bar bar;


    @Test
    void testAfterThrowingAdvice() {
        Assertions.assertThrows(CustomerBrokenException.class, () ->
                assertTrue("Customer is not broken ",
                        Tests.fromSystemOut(()-> bar.sellSquishee(aopPerson)).contains("Hmmm...")));
    }
}