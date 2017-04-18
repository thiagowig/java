package br.com.ithiago;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Testing some Java 8 features
 *
 */
public class App {

    private List<User> users;

    private  Map<String, Integer> items;

    public static void main( String[] args ) {
        App app = new App();
        app.execute();
    }

    private void execute() {
        init();
        listOperations();
        mapOperations();
        filterWithStream();
        collect();
        findAny();
        findAnyMultipleConditions();
        filterAndMap();
        filterAndMapAList();
        toUpperCase();
        groupingBy();
        stringJoiner();
    }

    private void init() {
        users = new ArrayList<>();
        users.add(new User("Marco", 60));
        users.add(new User("Tania", 50));
        users.add(new User("Simone", 25));
        users.add(new User("Thiago", 30));

        items = new HashMap<>();
        items.put("Marco", 60);
        items.put("Tania", 50);
        items.put("Simone", 30);
        items.put("Thiago", 25);
    }

    private void listOperations() {
        System.out.println("\n### listOperations");

        users.sort((user01, user02) -> user01.getAge() - user02.getAge());

        users.forEach((user) -> System.out.println(user.getName()));

        users.forEach((user) -> {
            System.out.println(user.getName());

            if (user.getAge() > 27) {
                System.out.println("Old guy");
            }
        });
    }

    private void mapOperations() {
        System.out.println("\n### mapOperations");

        items.forEach((key, value) -> System.out.println("Key: " + key + ". Value: " + value));
    }

    private void filterWithStream() {
        System.out.println("\n### filterWithStream");

        users.stream()
                .filter(user -> user.getAge() > 40)
                .forEach(System.out::println);
    }

    private void collect() {
        System.out.println("\n### collect");

        List<User> newUsers = users.stream()
                .filter(user -> user.getAge() < 59)
                .collect(Collectors.toList());

        newUsers.forEach(user -> System.out.println(user.getName()));
    }

    private void findAny() {
        System.out.println("\n### findAny");

        User user = users.stream()
                .filter(u -> u.getName().equals("Thiago"))
                .findAny()
                .orElse(null);

        System.out.println(user);
    }

    private void findAnyMultipleConditions() {
        System.out.println("\n### findAnyMultipleConditions");

        User user = users.stream()
                .filter(u -> {
                    return u.getName().equals("Tania") && u.getAge() > 20;
                })
                .findAny()
                .orElse(null);

        System.out.println(user);
    }

    private void filterAndMap() {
        System.out.println("\n### filterAndMap");

        String userName = users.stream()
                .filter( user -> user.getName().equals("Thiago"))
                .map(User::getName)
                .findAny()
                .orElse("");

        System.out.println(userName);
    }

    private void filterAndMapAList() {
        System.out.println("\n### filterAndMapAList");

        List<String> usersNames = users.stream()
                .map(User::getName)
                .collect(Collectors.toList());

        usersNames.forEach(System.out::println);
    }

    private void toUpperCase() {
        System.out.println("\n### toUpperCase");

        List<String> usersNames = users.stream()
                .map(User::getName)
                .collect(Collectors.toList());

        List<String> usersNamesUpper = usersNames.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        usersNamesUpper.forEach(System.out::println);
    }

    private void groupingBy() {
        System.out.println("\n### groupingBy");

        List<String> items = Arrays.asList("apple", "banana", "orange", "apple", "orange", "apple");

        Map<String, Long> result = items.stream().collect(Collectors.groupingBy(
                Function.identity(), Collectors.counting()
        ));

        System.out.println(result);
    }

    private void stringJoiner() {
        System.out.println("\n### stringJoiner");

        StringJoiner stringJoiner = new StringJoiner(", ");

        stringJoiner.add("Thiago");
        stringJoiner.add("Santos");
        stringJoiner.add("Fonseca");

        System.out.println(stringJoiner.toString());
    }
}
