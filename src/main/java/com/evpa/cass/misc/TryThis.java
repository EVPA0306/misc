package com.evpa.cass.misc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class TryThis {
    public void speak() {
        out.println("Bonjour!");
    }

    public void go() {
        Something s = this::speak;
        s.execute();
    }

    public static void main(String[] args) {
        new TryThis().go();
        List<Integer> num = Arrays.asList(0,1,2,3,4,5,6,7);
        List<Integer> newNum;
        newNum = num.stream()
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toList());
        out.println(newNum);
    }

    private static void checks(Object check) {
        if (check instanceof List) {
            out.println("List");
        } else if (check instanceof String) {
            out.println("String");
        } else {
            out.println("Object");
        }
    }

}
