import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class NextSmallestPalindrome {
    /**
     * * Write a function to find the next smallest palindrome of a specified number.
     *
     * > nextSmallestPalindrome(99)
     * 101
     * > nextSmallestPalindrome(1221)
     * 1331
     * > nextSmallestPalindrome(120)
     * 121
     */
    public static int nextSmallestPalindrome(int num) {
        String numstr = "" + num;
        for (int i = num + 1;; i++) {
            String s = "" + i;
            if (numstr.equals(s) || s.equals(new StringBuilder(s).reverse().toString())) return i;
        }
    }
}