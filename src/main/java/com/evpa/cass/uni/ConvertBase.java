package com.evpa.cass.uni;

public class ConvertBase {

    private static String str = "615";
    private static int one = 7;
    private static int two = 13;

    public static void main(String[] args) {
        System.out.println(convertBase(str,one,two));
    }

    private static String convertBase(String numAsString, int one, int two) {
        boolean isNegative = numAsString.startsWith("-");
        int numAsInt = 0;

        for (int i = isNegative ? 1 : 0; i < numAsString.length(); i++) {
            numAsInt *= one;
            numAsInt += Character.isDigit(numAsString.charAt(i))
                    ? numAsString.charAt(i) - '0'
                    : numAsString.charAt(i) - 'A' + 10;
        }
        return (isNegative ? "-" : "") + (numAsInt == 0 ? "0" : constructFromBase(numAsInt,two));
    }

    private static String constructFromBase(int numAsInt, int base) {
        return numAsInt == 0
                ? ""
                : constructFromBase(numAsInt / base, base)
                    + (char) (numAsInt % base >= 10 ? 'A' + numAsInt % base - 10 : '0' + numAsInt % base);
    }
}
