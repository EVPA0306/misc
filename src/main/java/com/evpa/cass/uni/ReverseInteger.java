package com.evpa.cass.uni;

import jnr.ffi.annotations.In;

public class ReverseInteger {

    private static Integer TC_ONE = 123; //321
    private static Integer TC_TWO = -123; //-321
    private static Integer TC_THREE = 120; //21
    private static Integer TC_FOUR = 1534236469;
    private static String TC_FIVE = "-123";

    public static void main(String[] args) {
        //System.out.println(reverse(TC_FOUR));
        System.out.println(intToString(TC_FOUR));
        System.out.println(strToInt(TC_FIVE));
    }

    private static int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
            res = 0;
        return (int) res;
    }

    private static String intToString(int xInt) {
        boolean isNegative = false;
        if (xInt < 0) {
            isNegative = true;
        }
        StringBuilder sB = new StringBuilder();
        do {
            sB.append((char)('0' + Math.abs(xInt % 10)));
            xInt /= 10;
        } while (xInt != 0);
        if (isNegative)
            sB.append("-");
        sB.reverse();
        return sB.toString();
    }

    private static int strToInt(String str) {
        int result = 0;
        for (int i = str.charAt(0) == '-' ? 1 :0 ; i < str.length(); i++) {
            //char ch = str.charAt(i);
            final int digit = str.charAt(i) - '0';
            result = result * 10 + digit;
        }
        return str.charAt(0) == '-' ? -result : result;
    }
}

