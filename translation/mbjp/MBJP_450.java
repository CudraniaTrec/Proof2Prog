import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ExtractString {
    /**
     * * Write a function to extract specified size of strings from a give list of string values.
     *
     * > extractString(["Python", "list", "exercises", "practice", "solution"], 8)
     * ["practice", "solution"]
     * > extractString(["Python", "list", "exercises", "practice", "solution"], 6)
     * ["Python"]
     * > extractString(["Python", "list", "exercises", "practice", "solution"], 9)
     * ["exercises"]
     */
    public static List<String> extractString(List<String> str, int l) {
        List<String> result = new ArrayList<>();
        for (String s : str) {
            if (s.length() == l) {
                result.add(s);
            }
        }
        return result;
    }
}