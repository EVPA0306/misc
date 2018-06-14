package com.evpa.cass.uni;

public class PhDStudent implements Faculty, Rookie {

    public static void main(String[] args) {
        Rookie rookie  = new PhDStudent();
        rookie.schedule();
    }
}
