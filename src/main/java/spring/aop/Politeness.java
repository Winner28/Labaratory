package spring.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import spring.model.bar.Squishee;
import spring.model.ioc.Person;

@Aspect
@Component
@EnableAspectJAutoProxy
public class Politeness {

    @Before("execution(* sellSquishee(..)) && args(person)")
    public void sayHello(Person person) {
        AopLog.append("Hello." + person.getName() +  "How are you doing?");
    }

    @AfterReturning(pointcut = "execution(* sellSquishee(..))",
            returning = "retVal", argNames = "retVal")
    public void askOpinion(Squishee retVal) {
        AopLog.append("Is %s Good Enough?%n" + retVal.getName());
    }

    @AfterThrowing("execution(* sellSquishee(..))")
    public void sayYouAreNotAllowed() {
        AopLog.append("Hmmm... \n");
    }

    @AfterReturning("execution(* sellSquishee(..))")
    public void sayGoodBye() {
        AopLog.append("Good Bye! \n");
    }

    @Around("execution(* sellSquishee(..))")
    public Object sayPoliteWordsAndSell(ProceedingJoinPoint pjp) throws Throwable {
        AopLog.append("Hi! \n");
        Object retVal = pjp.proceed();
        AopLog.append(("See you! \n"));
        return retVal;
    }



}
