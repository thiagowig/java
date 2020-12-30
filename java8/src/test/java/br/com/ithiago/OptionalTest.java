package br.com.ithiago;


import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalTest {


    @Test
    public void optionalsNotPresent() {
        Optional<String> emptyString = Optional.empty();
        Assert.assertFalse(emptyString.isPresent());
    }

    @Test
    public void optionalIsEmpty() {
        Optional<String> value = Optional.of("Thiago");
        Assert.assertFalse(value.isEmpty());

        value = Optional.ofNullable(null);
        Assert.assertTrue(value.isEmpty());
    }

    @Test
    public void optionalIsPresent() {
        String name = "Thiago";
        Optional<String> emptyString = Optional.of(name);
        Assert.assertTrue(emptyString.isPresent());
    }

    @Test(expected = NullPointerException.class)
    public void raiseException() {
        String name = null;
        Optional.of(name);
    }

    @Test
    public void optionalOfNullable() {
        String name = null;
        Optional.ofNullable(name);
    }

    @Test
    public void optionalIfPresent() {
        Optional<String> nameOptional = Optional.of("Thiago");
        nameOptional.ifPresent(name -> System.out.println(name));
    }

    @Test
    public void optionalWithOrElse() {
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElse("Thiago");

        Assert.assertSame(name, "Thiago");
    }

    @Test
    public void optionalWithOrElseGet() {
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElseGet(() -> {
            Integer value = 1 + 2;
            return value + " Thiago";
        });

        Assert.assertEquals(name, "3 Thiago");
    }

    @Test
    public void optionalWithOrElseGetOverlap() {
        String text = null;

        String defaultText = Optional.ofNullable(text).orElseGet(this::getMyDefault);
        Assert.assertEquals("Default Value", defaultText);

        defaultText = Optional.ofNullable(text).orElse(getMyDefault());
        Assert.assertEquals("Default Value", defaultText);
    }

    @Test
    public void optionalWithOrElseGetDiffer() {
        String text = "Text present";

        System.out.println("Using orElseGet");
        String defaultText = Optional.ofNullable(text).orElseGet(this::getMyDefault);
        Assert.assertEquals("Text present", defaultText);

        System.out.println("Using orElse");
        defaultText = Optional.ofNullable(text).orElse(getMyDefault());
        Assert.assertEquals("Text present", defaultText);
    }

    @Test(expected = IllegalArgumentException.class)
    public void optionalWithOrElseThrows() {
        String name = null;

        String value = Optional.ofNullable(name).orElseThrow(IllegalArgumentException::new);

    }

    @Test(expected = NoSuchElementException.class)
    public void optionalWithOrElseThrowsNoSuch() {
        String name = null;

        String value = Optional.ofNullable(name).orElseThrow();
    }

    @Test
    public void optionalWithFilter() {
        Integer year = 2016;

        Optional<Integer> yearOptional = Optional.of(year);
        Boolean is2016 = yearOptional.filter(y -> y == 2016).isPresent();
        Assert.assertTrue(is2016);

        Boolean is2017 = yearOptional.filter(y -> y == 2017).isPresent();
        Assert.assertFalse(is2017);
    }

    @Test
    public void optionalWithFilterAndMap() {
        Assert.assertFalse(isPriceInRange(new Modem(123)));
        Assert.assertFalse(isPriceInRange(new Modem(9)));
        Assert.assertFalse(isPriceInRange(null));
        Assert.assertTrue(isPriceInRange(new Modem(11)));
    }

    private Boolean isPriceInRange(Modem modem) {
        return Optional.ofNullable(modem)
                .map(Modem::getPrice)
                .filter(p -> p >= 10)
                .filter(p -> p <= 15)
                .isPresent();
    }

    @Test
    public void optionalWithMap() {
        List<String> companyNames = Arrays.asList("paypal", "oracle", "", "microsoft", "", "apple");
        Optional<List<String>> optionalList = Optional.of(companyNames);
        int listSize = optionalList.map(List::size).orElse(0);
        Assert.assertEquals(6, listSize);

        String name = "Thiago";
        Optional<String> optionalName = Optional.of(name);
        int length = optionalName.map(String::length).orElse(0);
        Assert.assertEquals(6, length);
    }

    public String getMyDefault() {
        System.out.println("Getting Default Value");
        return "Default Value";
    }

    public class Modem {
        private Integer price;

        public Modem(Integer price) {
            this.price = price;
        }

        public Integer getPrice() {
            return price;
        }
    }

    public class Person {
        private String name;
        private int age;
        private String password;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getPassword() {
            return password;
        }
    }

}
