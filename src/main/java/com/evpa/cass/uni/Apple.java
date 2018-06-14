package com.evpa.cass.uni;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Apple {

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e: list) {
            if (p.test(e))
                result.add(e);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7);
        List<Integer> evenNum = filter(nums, (Integer i) -> i % 2 == 0);
        System.out.println(evenNum);
    }
}
