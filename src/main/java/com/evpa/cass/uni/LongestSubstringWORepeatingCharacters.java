package com.evpa.cass.uni;

import java.util.*;

public class LongestSubstringWORepeatingCharacters {

    private static String ONE = "abcabcbb"; // abc 3
    private static String TWO = "bbbbbb"; //b 1
    private static String THREE = "pwwkew"; //wke 3
    private static String FOUR = ""; // 0
    private static String FIVE = "aab";//2
    private static final String SIX = "dvdf";//3

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(ONE));
    }

    public static int lengthOfLongestSubstring(String s) {

            Map<Character,Integer> sub;
            StringBuilder sB;
            List<String> strs = new ArrayList<>();


            while (s.length() > 0) {

                sub = new LinkedHashMap<>();
                sB = new StringBuilder();

                for (int i = 0; i < s.length(); i++) {
                    Character key = s.charAt(i);
                    if (sub.containsKey(key)) {
                        break;
                    } else {
                        sB.append(key);
                        sub.put(key, i);
                    }
                }
                strs.add(sB.toString());
                s = s.substring(sB.length(),s.length());
            }

            //Old version
            /*strs.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return (o1.length() > o2.length())
                            ? -1
                            : ((o1.length() == o2.length()) ? 0 : 1);
                }
            });*/
            //New way
            strs.sort((s1,s2) ->
                        s1.length() > s2.length()
                        ? -1
                        : ((s1.length() == s2.length()) ? 0 : 1)
            );

            return strs.get(0).length();
        }
    }
