import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class TextMatchOne {
    /**
     * * Write a function that matches a string that has an a followed by one or more b's.
     *
     * > textMatchOne("ac")
     * "Not matched!"
     * > textMatchOne("dc")
     * "Not matched!"
     * > textMatchOne("abba")
     * "Found a match!"
     */
    public static String textMatchOne(String text) {
        if (text.isEmpty()) {
            return "Not matched!";
        }
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == 'a' || text.charAt(i) == 'b') {
                if (i + 1 < text.length()) {
                    if (text.charAt(i + 1) == 'a' || text.charAt(i + 1) == 'b') {
                        return "Found a match!";
                    }
                }
            }
        }
        return "Not matched!";
    }
}