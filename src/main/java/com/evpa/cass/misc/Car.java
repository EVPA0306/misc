package com.evpa.cass.misc;

import lombok.Data;

import java.util.Optional;

@Data
public class Car {
    private String color;
    private String make;
    private String model;
    private Optional<Insurance> insurance;

    public Car withColor(String color) {
        this.color = color;
        return this;
    }
}
