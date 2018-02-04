package spring.model.Bar;

import org.aspectj.lang.annotation.Aspect;
import spring.aop.Squishee;
import spring.model.Person;

@Aspect
public class ApuBar implements Bar {
    @Override
    public Squishee sellSquishee(Person customer) {
        if (customer.isBroke())
            throw new CustomerBrokenException();

        System.out.println("Here is your Squishee \n");
        return new Squishee("Usual Squishee");
    }
}
