import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CheckLiterals {
    /**
     * * Write a function to search some literals strings in a string by using regex.
     *
     * > checkLiterals("The quick brown fox jumps over the lazy dog.", ["fox"])
     * "Matched!"
     * > checkLiterals("The quick brown fox jumps over the lazy dog.", ["horse"])
     * "Not Matched!"
     * > checkLiterals("The quick brown fox jumps over the lazy dog.", ["lazy"])
     * "Matched!"
     */
    public static String checkLiterals(String text, List<String> patterns) {
        String result = "";
        for (String pattern : patterns) {
            if (text.contains(pattern)) {
                result = result + "Matched!";
            } else {
                result = result + "Not Matched!";
            }
        }
        return result;
    }
}