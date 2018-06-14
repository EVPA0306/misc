package com.evpa.cass.uni;

public class Palidrom {
    private static String ONE = "kazzak";

    public static void main(String[] args) {
        System.out.println(isPalidromic(ONE));
    }

    private static boolean isPalidromic(String string) {
        for (int i = 0, j = string.length() - 1; i < j; i++, j--) {
            if (string.charAt(i) != string.charAt(j))
                return false;
        }
        return true;
    }

}
