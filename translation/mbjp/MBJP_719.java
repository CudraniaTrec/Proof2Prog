import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class TextMatch {
    /**
     * * Write a function that matches a string that has an a followed by zero or more b's.
     *
     * > textMatch("ac")
     * "Found a match!"
     * > textMatch("dc")
     * "Not matched!"
     * > textMatch("abba")
     * "Found a match!"
     */
    public static String textMatch(String text) {
        char[] chars = text.toCharArray();
        for (char c : chars) {
            if (c == 'a' || c == 'A') {
                return "Found a match!";
            }
        }
        return "Not matched!";
    }
}