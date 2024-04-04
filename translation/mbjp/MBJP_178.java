import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class StringLiterals {
    /**
     * * Write a function to search some literals strings in a string.
     *
     * > stringLiterals(["language"], "python language")
     * "Matched!"
     * > stringLiterals(["program"], "python language")
     * "Not Matched!"
     * > stringLiterals(["python"], "programming language")
     * "Not Matched!"
     */
    public static String stringLiterals(List<String> patterns, String text) {
        String res = "Not Matched!";
        for (int i = 0; i < patterns.size(); i++) {
            if (text.contains(patterns.get(i))) {
                res = "Matched!";
                break;
            }
        }
        return res;
    }
}