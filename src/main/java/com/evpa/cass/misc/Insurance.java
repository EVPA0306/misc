package com.evpa.cass.misc;

import lombok.Data;

@Data
public class Insurance implements Drawable {
    private String name;

    @Override
    public void draw() {
        System.out.println("Draw Insurance");
    }
}
