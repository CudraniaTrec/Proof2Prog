import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CountSubstringWithEqualEnds {
    /**
     * * Write a Java function to count the number of substrings with same first and last characters.
     *
     * > countSubstringWithEqualEnds("aba")
     * 4
     * > countSubstringWithEqualEnds("abcab")
     * 7
     * > countSubstringWithEqualEnds("abc")
     * 3
     */
    public static int countSubstringWithEqualEnds(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                if (s.endsWith(sub)) {
                    count++;
                }
            }
        }
        return count;
    }
}