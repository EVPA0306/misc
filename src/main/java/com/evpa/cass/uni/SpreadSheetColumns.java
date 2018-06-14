package com.evpa.cass.uni;

public class SpreadSheetColumns {
    private static final String col = "AA";
    private static final int colId = 1;

    public static void main(String[] args) {
        System.out.println(ssDecodeColId(col));
        System.out.println(intDecodeColLetter(colId));
    }

    private static String intDecodeColLetter(int colId) {
        int intResult = 0;
        StringBuilder sb = new StringBuilder();
            intResult = ('A' + colId % 27 - 1);
            sb.append((char) intResult);
        return sb.toString();
    }

    private static int ssDecodeColId(String col) {
        int result = 0;
        for (int i = 0; i < col.length(); i++) {
            char c = col.charAt(i);
            result = result * 26 + c - 'A' + 1;
        }
        return result;
    }
}
