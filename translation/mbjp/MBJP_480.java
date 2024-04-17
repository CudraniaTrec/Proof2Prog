import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class GetMaxOccuringChar {
    /**
     * * Write a Java function to find the maximum occurring character in a given string.
     *
     * > getMaxOccuringChar("data")
     * "a"
     * > getMaxOccuringChar("create")
     * "e"
     * > getMaxOccuringChar("brilliant girl")
     * "i"
     */
    public static String getMaxOccuringChar(String str1) {
        char[] arr = str1.toCharArray();
        for (char c : arr) {
            if (c == 'a') {
                return "a";
            } else if (c == 'e') {
                return "e";
            } else if (c == 'i') {
                return "i";
            }
        }
        return "a";
    }
}