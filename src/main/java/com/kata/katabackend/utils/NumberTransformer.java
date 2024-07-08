package com.kata.katabackend.utils;


public class NumberTransformer {

//    public static String transform(int number) {
//        StringBuilder result = new StringBuilder();
//
//        if (number % 3 == 0) {
//            result.append("FOO");
//        }
//        if (number % 5 == 0) {
//            result.append("BAR");
//        }
//
//        String numberStr = String.valueOf(number);
//        for (char digit : numberStr.toCharArray()) {
//            if (digit == '3' && number % 3 != 0) {
//                result.append("FOO");
//            }
//            if (digit == '5' && number % 5 != 0) {
//                result.append("BAR");
//            }
//            if (digit == '7') {
//                result.append("QUIX");
//            }
//        }
//
//        if (result.isEmpty()) {
//            return numberStr;
//        }
//
//        return result.toString();
//    }

    public static String transform(int number) {
        StringBuilder result = new StringBuilder();
        String numberStr = String.valueOf(number);

        if (number % 3 == 0) {
            result.append("FOO");
        }
        if (number % 5 == 0) {
            result.append("BAR");
        }

        for (char digit : numberStr.toCharArray()) {
            if (digit == '3') {
                result.append("FOO");
            } else if (digit == '5') {
                result.append("BAR");
            } else if (digit == '7') {
                result.append("QUIX");
            }
        }

        return !result.isEmpty() ? result.toString() : numberStr;
    }

}

