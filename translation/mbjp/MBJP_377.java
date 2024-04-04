import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class RemoveChar {
    /**
     * * Write a Java function to remove all occurrences of a character in a given string.
     *
     * > removeChar("aba", "a")
     * "b"
     * > removeChar("toggle", "g")
     * "tole"
     * > removeChar("aabbc", "b")
     * "aac"
     */
    public static String removeChar(String s, String c) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (c.indexOf(s.charAt(i)) == -1) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}