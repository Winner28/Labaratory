package spring;

import lombok.SneakyThrows;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import spring.model.ioc.Person;
import spring.model.ioc.SimplePerson;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Tests {

    String APPLICATION_CONTEXT_XML_FILE_NAME = "ioc.xml";

    @SneakyThrows
    public static String fromSystemOut(Runnable runnable) {

        PrintStream realOut = System.out;

        try (val out = new ByteArrayOutputStream();
             val printStream = new PrintStream(out)) {

            System.setOut(printStream);
            runnable.run();

            return new String(out.toByteArray());

        } finally {
            System.setOut(realOut);
        }
    }

    static String toTestPropertiesResourceName (String name) {
        return String.format("./src/test/resources/%s.properties", name);
    }

    static Iterable<String> toTestSqlResourceNames (String name) {
        List<String> result = new ArrayList<>();
        String sqlFilePathName;
        for (int i = 1; new File(sqlFilePathName = toTestSqlResourceName(Integer.toString(i))).exists(); i++)
            result.add(sqlFilePathName);
        return result;
    }

    static String toTestSqlResourceName (String name) {
        return String.format("./src/test/resources/%s.sql", name);
    }

    /**
     * @apiNote This method use some dirty hack in reflection API for making access to private field!
     */
    @SneakyThrows
    static void setValue2Field(Object o, String name, Object broke) {
        assert o.getClass() == SimplePerson.class;
        Field brokeField = o.getClass().getDeclaredField(name);
//        if (!brokeField.canAccess(person))
        brokeField.setAccessible(true);
        brokeField.set(o, broke);
    }
}
