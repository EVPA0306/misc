package com.evpa.cass.uni;

public interface Faculty extends Student{
    default void schedule() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    };
}
