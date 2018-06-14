package com.evpa.cass.misc;

import java.util.Arrays;
import java.util.List;

public class TestGenerics {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(new Student("Eugene"), new Student("Marina"));
        printList(students);
        List<Faculty> faculties = Arrays.asList(new Faculty("Mama"), new Faculty("Papa"));
        printList(faculties);
    }

    private static void printList(List<? extends Person> people) {
        people.stream()
                .forEach(Person::draw);
    }
}
