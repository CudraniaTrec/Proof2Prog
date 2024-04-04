import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class RemoveOcc {
    /**
     * * Write a Java function to remove first and last occurrence of a given character from the string.
     *
     * > removeOcc("hello", "l")
     * "heo"
     * > removeOcc("abcda", "a")
     * "bcd"
     * > removeOcc("PHP", "P")
     * "H"
     */
    public static String removeOcc(String s, String ch) {
        if (s == null || s.length() == 0 || ch == null || ch.length() == 0) {
            return s;
        }
        int index = s.indexOf(ch);
        if (index == -1) {
            return s;
        }
        int lastIndex = s.lastIndexOf(ch);
        if (lastIndex == -1) {
            return s;
        }
        return s.substring(0, index) + removeOcc(s.substring(index + ch.length()), ch);
    }
}