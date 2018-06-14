package com.evpa.cass;

import com.evpa.cass.misc.Person;
import com.evpa.cass.util.OptionalUtility;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;
import java.util.Properties;
import java.util.function.Supplier;

import static org.junit.Assert.assertEquals;

public class PropertiesTest {

    private Properties properties = new Properties();

    @Before
    public void setUp() {
        properties.setProperty("a","5");
        properties.setProperty("b", "true");
        properties.setProperty("c","-3");
    }

    @Test
    public void testProperties() {
        //Assertions
        assertEquals(5, readDurationOptional(properties, "a"));
        assertEquals(0, readDurationOptional(properties, "b"));
        assertEquals(0, readDurationOptional(properties, "c"));
        assertEquals(0, readDurationOptional(properties, "d"));
    }

    private int readDurationOptional(Properties props, String name) {
        return Optional.ofNullable(props.getProperty(name))
                .flatMap(OptionalUtility::stringToInt)
                .filter(i -> i > 0)
                .orElse(0);
    }

    private int readDuration(Properties props, String name) {
        String value = props.getProperty(name);
        if (value != null) {
            try {
                int i = Integer.valueOf(value);
                if (i > 0)
                    return i;
            } catch (NumberFormatException e) {}
        }
        return 0;
    }

    @Test
    public void testVar() {
        int portNumber = 8080;
        Supplier<Person> personSupplier = Person::new;
        Person person = personSupplier.get();
        Runnable runnable = () -> {
            //portNumber = 9090;
            System.out.println(portNumber);
        };
    }
}
