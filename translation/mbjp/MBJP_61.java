import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CountSubstrings {
    /**
     * * Write a Java function to count number of substrings with the sum of digits equal to their length.
     *
     * > countSubstrings("112112", 6)
     * 6
     * > countSubstrings("111", 3)
     * 6
     * > countSubstrings("1101112", 7)
     * 12
     */
    public static int countSubstrings(String s, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String sub = s.substring(i, j);
                int num = 0;
                for (int k = 0; k < sub.length(); k++) {
                    num += sub.charAt(k) - '0';
                }
                if (num == sub.length()) {
                    count++;
                }
            }
        }
        return count;
    }
}