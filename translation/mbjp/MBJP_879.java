import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class TextMatch {
    /**
     * * Write a function that matches a string that has an 'a' followed by anything, ending in 'b' by using regex.
     *
     * > textMatch("aabbbbd")
     * "Not matched!"
     * > textMatch("aabAbbbc")
     * "Not matched!"
     * > textMatch("accddbbjjjb")
     * "Found a match!"
     */
    public static String textMatch(String text) {
        String match = "Not matched!";
        String regex = "^[a-zA-Z]*a.*b$";

        if (text.matches(regex)) {
            return "Found a match!";
        }
        return match;
    }
}