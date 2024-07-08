package com.kata.katabackend.utils;

public class NumberTransformer {


    public static final String FOO = "FOO";
    public static final String BAR = "BAR";
    public static final String QUIX = "QUIX";

    /**
     * Transforms a number into a string based on specific rules.
     *
     * @param number the number to transform
     * @return the transformed string
     */
    public static String transform(int number) {
        StringBuilder result = new StringBuilder();
        String numberStr = String.valueOf(number);

        if (number % 3 == 0) {
            result.append(FOO);
        }
        if (number % 5 == 0) {
            result.append(BAR);
        }

        for (char digit : numberStr.toCharArray()) {
            if (digit == '3') {
                result.append(FOO);
            } else if (digit == '5') {
                result.append(BAR);
            } else if (digit == '7') {
                result.append(QUIX);
            }
        }

        return !result.isEmpty() ? result.toString() : numberStr;
    }

}

