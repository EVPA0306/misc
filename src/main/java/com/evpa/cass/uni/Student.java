package com.evpa.cass.uni;

public interface Student {
    default void schedule() {
        System.out.println("Student");
    };
}
