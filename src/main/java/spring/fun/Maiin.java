package spring.fun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.model.ioc.Person;
import spring.model.ioc.SimplePerson;
import spring.fun.Animal.TypoWord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Maiin {
    public static void main(String[] args) {
        Animal animal = new Animal("cow", 3);
        TypoWord typoWord = animal.new TypoWord(3,"a");
        typoWord.sayValueAndName();
        Animal.TypoStatic typoStatic = new Animal.TypoStatic(123);
        List<Animal> animals = new LinkedList<>();
        Map<String, Animal> animalMap = new HashMap<>();
        animalMap.put("an", animal);
        Set<Animal> set = new HashSet<>();
        set.add(null);





    }

    private static void proceedAnimal(Animal animal) {
        animal.setName("name");
    }
}
