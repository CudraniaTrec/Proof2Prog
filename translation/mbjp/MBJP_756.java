import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class TextMatchZeroOne {
    /**
     * * Write a function that matches a string that has an a followed by zero or one 'b'.
     *
     * > textMatchZeroOne("ac")
     * "Found a match!"
     * > textMatchZeroOne("dc")
     * "Not matched!"
     * > textMatchZeroOne("abbbba")
     * "Found a match!"
     */
    public static String textMatchZeroOne(String text) {
        if (text.length() == 0) {
            return text;
        }
        if (text.length() == 1) {
            return "Found a match!";
        }
        StringBuilder result = new StringBuilder();
        if (text.charAt(0) == 'a') {
            result.append("Found a match!");
        } else if (text.charAt(0) == 'b') {
            result.append("Found a match!");
        } else {
            result.append("Not matched!");
        }
        return result.toString();
    }
}