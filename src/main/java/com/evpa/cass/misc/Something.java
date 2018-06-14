package com.evpa.cass.misc;

import static java.lang.System.out;

public interface Something {
    void execute();
    default void speak() {
        out.println("Hello!");
    }
}
