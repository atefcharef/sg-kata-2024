package com.kata.katabackend.utils;

import com.kata.katabackend.exceptions.NumberNotInRangeException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
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
    public static String transform(int number) throws NumberNotInRangeException  {

        if (number < 0 || number > 100) {
            throw new NumberNotInRangeException("Number must be between 0 and 100");
        }

        StringBuilder result = new StringBuilder();
        String numberStr = String.valueOf(number);

        if (number % 3 == 0) {
            result.append(FOO);
        }
        if (number % 5 == 0) {
            result.append(BAR);
        }

        for (char digit : numberStr.toCharArray()) {
            switch (digit) {
                case '3':
                    result.append(FOO);
                    break;
                case '5':
                    result.append(BAR);
                    break;
                case '7':
                    result.append(QUIX);
                    break;
                default:
                    // No action required for other digits
                    break;
            }
        }

        return !result.isEmpty() ? result.toString() : numberStr;
    }

}

