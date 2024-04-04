import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class OccuranceSubstring {
    /**
     * * Write a function to find the occurrence and position of the substrings within a string.
     *
     * > occuranceSubstring("python programming, python language", "python")
     * ["python", 0, 6]
     * > occuranceSubstring("python programming,programming language", "programming")
     * ["programming", 7, 18]
     * > occuranceSubstring("python programming,programming language", "language")
     * ["language", 31, 39]
     */
    public static List<Object> occuranceSubstring(String text, String pattern) {
        int i = text.indexOf(pattern);
        if (i >= 0) {
            List<Object> list = new ArrayList<>();
            list.add(pattern);
            list.add(i);
            list.add(i + pattern.length());
            return list;
        } else {
            return new ArrayList<>();
        }
    }
}