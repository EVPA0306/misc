package com.evpa.cass.misc;

public class Faculty extends Person {

    private final String name;

    public Faculty(String name) {
        this.name = name;
    }

    @Override
    public void draw() {
        System.out.println("Draw Faculty " + name);
    }
}
