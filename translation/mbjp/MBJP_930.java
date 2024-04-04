import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class TextMatch {
    /**
     * * Write a function that matches a string that has an a followed by zero or more b's by using regex.
     *
     * > textMatch("msb")
     * "Not matched!"
     * > textMatch("a0c")
     * "Found a match!"
     * > textMatch("abbc")
     * "Found a match!"
     */
    public static String textMatch(String text) {
        return text.matches(".*a.*") ? "Found a match!" : "Not matched!";
    }
}