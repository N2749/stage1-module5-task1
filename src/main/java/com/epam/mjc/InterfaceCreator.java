package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return strings ->
                strings.stream().filter(s -> s.substring(0, 1).replaceAll("[A-Z]", "").isEmpty()).count() == strings.size();
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return integers -> {
            List<Integer> copy = new ArrayList<>(integers);
            copy = copy.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
            integers.addAll(copy);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () ->
                values.stream()
                        .filter(s -> s.substring(0, 1).replaceAll("[A-Z]", "").isEmpty())
                        .filter(s -> s.endsWith("."))
                        .filter(s -> s.split(" ").length > 3)
                        .collect(Collectors.toList());
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return list -> list.stream().collect(Collectors.toMap(s -> s, String::length));
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (l1, l2) -> {
            l1.addAll(l2);
            return l1;
        };
    }
}
