package com.technical.assessment.util;

public class StringUtil {

    public static String toSentenceCase(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }
}
