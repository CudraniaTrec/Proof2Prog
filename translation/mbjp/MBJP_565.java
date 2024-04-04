import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class Split {
    /**
     * * Write a Java function to split a string into characters.
     *
     * > split("python")
     * ["p", "y", "t", "h", "o", "n"]
     * > split("Name")
     * ["N", "a", "m", "e"]
     * > split("program")
     * ["p", "r", "o", "g", "r", "a", "m"]
     */
    public static List<String> split(String word) {
        List<String> strs = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            strs.add(word.substring(i, i + 1));
        }
        return strs;
    }
}