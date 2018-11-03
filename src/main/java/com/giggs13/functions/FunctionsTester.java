package com.giggs13.functions;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionsTester {
    public static void main(String[] args) {
        Map<String, Integer> nameMap = new HashMap<>();
        Integer value = nameMap.computeIfAbsent("John", s -> s.length());
        System.out.println(value);

        Predicate<Integer> predicate1 = (Integer num) -> num > 1;
        Predicate<Integer> predicate2 = (Integer num) -> num % 2 == 0;

        System.out.println(predicate1.test(3));
        System.out.println(predicate1.and(predicate2).test(2));
        check(99, (Integer num) -> {
            return num > 100;
        });
        check(101, num -> num > 100, str -> System.out.println(str));
        check(103, num -> num > 100, System.out::println);
        check(107, num -> num > 100, num -> "value is: " + num, System.out::println);
        check(107, num -> num > 100, num -> num * 2, System.out::println);
        check(107, num -> num > 100, num -> new BigDecimal("43"), System.out::println);
    }

    private static void check(Integer num, Predicate<Integer> predicate) {
        System.out.println(predicate.test(num));
    }

    private static void check(Integer num, Predicate<Integer> predicate, Consumer<Integer> consumer) {
        if (predicate.test(num)) {
            consumer.accept(num);
        }
    }

    private static <T, S> void check(T num, Predicate<T> predicate, Function<T, S> function,
                              Consumer<S> consumer) {
        if (predicate.test(num)) {
            consumer.accept(function.apply(num));
        }
    }
}
