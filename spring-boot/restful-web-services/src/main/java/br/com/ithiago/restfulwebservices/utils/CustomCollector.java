package br.com.ithiago.restfulwebservices.utils;

import br.com.ithiago.restfulwebservices.exception.NotFoundException;

import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CustomCollector {

    public static <T> Collector<T, ?, T> toSingleton() {
        return Collectors.collectingAndThen(
                Collectors.toList(),
                list -> {
                    if (list.size() == 0) {
                        throw new NotFoundException("Entity wasn't found by its id");

                    } else {
                        return list.get(0);
                    }
                }
        );
    }
}
