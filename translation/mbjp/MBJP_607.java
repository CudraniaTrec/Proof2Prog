import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindLiterals {
    /**
     * * Write a function to search a literals string in a string and also find the location within the original string where the pattern occurs by using regex.
     *
     * > findLiterals("The quick brown fox jumps over the lazy dog.", "fox")
     * ["fox", 16, 19]
     * > findLiterals("Its been a very crazy procedure right", "crazy")
     * ["crazy", 16, 21]
     * > findLiterals("Hardest choices required strongest will", "will")
     * ["will", 35, 39]
     */
    public static List<Object> findLiterals(String text, String pattern) {
        int start = text.indexOf(pattern);
        int end = start + pattern.length();
        return Arrays.asList(text.substring(start, end), start, end);
    }
}