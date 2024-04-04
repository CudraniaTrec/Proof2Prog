import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CheckEquality {
    /**
     * * Write a Java function to check whether the first and last characters of a given string are equal or not.
     *
     * > checkEquality("abcda")
     * "Equal"
     * > checkEquality("ab")
     * "Not Equal"
     * > checkEquality("mad")
     * "Not Equal"
     */
    public static String checkEquality(String str) {
        if (str.length() < 2) {
            return str;
        }
        if (str.charAt(0) == str.charAt(str.length() - 1)) {
            return "Equal";
        } else {
            return "Not Equal";
        }
    }
}