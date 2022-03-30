package com.okursan.author.security;

import java.util.Random;

public class StringEncoder {

    public static String encodeString(String str) {
        String finalStr = "";
        char[] charArr = str.toCharArray();

        for (char c : charArr) {
            int asci = process(c);
            finalStr += String.valueOf(asci);
        }

        return processString(processString(finalStr));
    }

    public static String decodeString(String str) {

        String finalStr = "";
        str = reverseString(str);
        String[] strArr = str.split("(?<=\\G.{3})");

        for (String str_ : strArr) {
            int num = Integer.parseInt(str_);
            int decoded = reverse(num);
            char c = (char) decoded;
            finalStr += c;
        }

        return finalStr;
    }

    private static int process(char c) {
        int asciInt = (int) c;
        return (4 * asciInt) + 4;
    }

    private static int reverse(int encodedInt) {
        return (encodedInt - 4) / 4;
    }

    private static String processString(String str) {
        int base = 0;
        int[] intArr = createRandomIndexCount(str);

        for (int i = 0; i < intArr.length; i++) {
            str = str.substring(base, intArr[i]) + createRandomNonNumChar() + str.substring(intArr[i], str.length());
        }

        return str;
    }

    private static String reverseString(String str) {
        String finalStr = "";

        char[] charArr = str.toCharArray();
        for (char c : charArr) {
            if (isNumeric(c)) {
                finalStr += c;
            }
        }

        return finalStr;
    }

    private static int[] createRandomIndexCount(String str) {

        Random random = new Random();
        int divide = random.nextInt(5) + 1;
        int count = str.length() / divide;

        int[] intArr = new int[count];
        for (int i = 0; i < count; i++) {
            intArr[i] = random.nextInt(str.length());
        }

        return intArr;
    }

    private static char createRandomNonNumChar() {
        Random random = new Random();

        char c = (char) (random.nextInt(68) + 58);

        return c;
    }

    private static boolean isNumeric(char c) {
        switch (c) {
            case '0':
                return true;
            case '1':
                return true;
            case '2':
                return true;
            case '3':
                return true;
            case '4':
                return true;
            case '5':
                return true;
            case '6':
                return true;
            case '7':
                return true;
            case '8':
                return true;
            case '9':
                return true;
            default:
                return false;
        }
    }
}
