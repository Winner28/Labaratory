package spring.fun;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Maiin {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
        RandomLoped loped = context.getBean(RandomLoped.class);
        System.out.println(loped.getMessage());
    }
}
