package com.evpa.cass.misc;

public class Student extends Person {

    private final String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void draw() {
        System.out.println("Draw Student " + name);
    }
}
