import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class NumberOfSubstrings {
    /**
     * * Write a Java function to count number of non-empty substrings of a given string.
     *
     * > numberOfSubstrings("abc")
     * 6
     * > numberOfSubstrings("abcd")
     * 10
     * > numberOfSubstrings("abcde")
     * 15
     */
    public static int numberOfSubstrings(String str) {
        int n = str.length();
        if (n == 0) return 0;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                String sub = str.substring(i, j + 1);
                if (sub.length() > 0) ++ans;
            }
        }
        return ans;
    }
}