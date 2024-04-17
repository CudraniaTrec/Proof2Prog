import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CountSubstringWithEqualEnds {
    /**
     * * Write a Java function to count all the substrings starting and ending with same characters.
     *
     * > countSubstringWithEqualEnds("abc")
     * 3
     * > countSubstringWithEqualEnds("abcda")
     * 6
     * > countSubstringWithEqualEnds("ab")
     * 2
     */
    public static int countSubstringWithEqualEnds(String s) {
        int[] counts = new int[s.length()];
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            int left = 0;
            int right = counts[s.charAt(i) - 'a'];
            while (left <= right) {
                total += counts[s.charAt(i) - 'a'];
                counts[s.charAt(i) - 'a']--;
                left++;
            }
        }
        return total;
    }
}