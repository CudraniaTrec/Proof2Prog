import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CheckChar {
    /**
     * * Write a function to check whether the given string starts and ends with the same character or not using regex.
     *
     * > checkChar("abba")
     * "Valid"
     * > checkChar("a")
     * "Valid"
     * > checkChar("abcd")
     * "Invalid"
     */
    public static String checkChar(String string) {
        char[] chars = string.toCharArray();
        int len = chars.length;
        if (len == 0) {
            return "Valid";
        }
        int start = 0;
        int end = len - 1;
        while (start <= end) {
            if (chars[start] != chars[end]) {
                return "Invalid";
            }
            start++;
            end--;
        }
        return "Valid";
    }
}