package com.evpa.cass.misc;

import lombok.Data;

import java.util.Optional;

@Data
public class Person implements Drawable {
    private int age;
    private Optional<Car> car;

    @Override
    public void draw() {
        System.out.println("Draw Person");
    }
}
