package com.evpa.cass.misc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Test {
    public static void main(String[] args) throws ParseException {

        Long millis = new SimpleDateFormat("MM/dd/yyyy").parse("12/19/2017").getTime();
        System.out.println(millis);
        System.out.println(new Date(1513666800000L));
        System.out.println(new Date(1519257600000L));

        System.out.println(new Date(1517873038000L));
        System.out.println(new Date(1518051600000L));

        long epoch = System.currentTimeMillis()/1000;
        System.out.println(epoch);

        List<Drawable> actors = new ArrayList<>();
        actors.add(new Insurance());
        actors.add(new Person());

        doSomething("KIA");
    }

    private static void doSomething(final String arg) {
        //arg = "Merz";
        System.out.println("arg = [" + arg + "]");
    }
}
