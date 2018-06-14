package com.evpa.cass.util;

import java.util.Optional;

public class OptionalUtility {

    public static Optional<Integer> stringToInt(String string) {
        try {
            return Optional.of(Integer.valueOf(string));
        } catch (NumberFormatException ex) {
            return Optional.empty();
        }
    }
}
