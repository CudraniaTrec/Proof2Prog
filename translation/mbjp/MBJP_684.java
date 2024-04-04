import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CountChar {
    /**
     * * Write a Java function to count occurences of a character in a repeated string.
     *
     * > countChar("abcac", "a")
     * 4
     * > countChar("abca", "c")
     * 2
     * > countChar("aba", "a")
     * 7
     */
    public static int countChar(String str, String x) {
        int count = 0;
        int n = 10;
        int repititions = n / str.length();
        int l = n % str.length();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == x.charAt(0)) {
                count += 1;
            }
        }
        count = count * repititions;
        l = n % str.length();
        for (int i = 0; i < l; i++) {
            if (str.charAt(i) == x.charAt(0)) {
                count += 1;
            }
        }
        return count;
    }
}