import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class TextMatchTwoThree {
    /**
     * * Write a function that matches a string that has an a followed by two to three 'b'.
     *
     * > textMatchTwoThree("ac")
     * "Not matched!"
     * > textMatchTwoThree("dc")
     * "Not matched!"
     * > textMatchTwoThree("abbbba")
     * "Found a match!"
     */
    public static String textMatchTwoThree(String text) {
        String[] words = text.split(" ");
        int count = 0;
        for (String word : words) {
            if (word.length() > 3) {
                count++;
            }
        }
        return count == 1 ? "Found a match!" : "Not matched!";
    }
}