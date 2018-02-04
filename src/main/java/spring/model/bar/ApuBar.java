package spring.model.bar;

import org.springframework.stereotype.Component;
import spring.aop.AopLog;
import spring.model.ioc.Person;

@Component("bar")
public class ApuBar implements Bar {

    @Override
    public Squishee sellSquishee(Person customer) {
        if (customer.isBroke())
            throw new CustomerBrokenException();

        AopLog.append("Here is your Squishee \n");
        return new Squishee("Usual Squishee");
    }
}
