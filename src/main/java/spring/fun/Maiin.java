package spring.fun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.model.ioc.Person;
import spring.model.ioc.SimplePerson;
import spring.fun.Animal.TypoWord;

import java.util.ArrayList;
import java.util.List;

public class Maiin {
    public static void main(String[] args) {
        Animal animal = new Animal("cow", 3);
        TypoWord typoWord = animal.new TypoWord(3,"a");
        typoWord.sayValueAndName();
        Animal.TypoStatic typoStatic = new Animal.TypoStatic(123);
        List<Animal> animals = new ArrayList<>();
    }

    private static void proceedAnimal(Animal animal) {
        animal.setName("name");
    }
}
