import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class EndNum {
    /**
     * * Write a function to check for a number at the end of a string.
     *
     * > endNum("abcdef")
     * false
     * > endNum("abcdef7")
     * true
     * > endNum("abc")
     * false
     */
    public static Boolean endNum(String string) {
        int max = 0;
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c >= '0' && c <= '9') {
                max = Math.max(max, c - '0');
            }
        }
        return max > 0 && max == string.length();
    }
}