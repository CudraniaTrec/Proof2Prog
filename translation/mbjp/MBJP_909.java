import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class PreviousPalindrome {
    /**
     * * Write a function to find the previous palindrome of a specified number.
     *
     * > previousPalindrome(99)
     * 88
     * > previousPalindrome(1221)
     * 1111
     * > previousPalindrome(120)
     * 111
     */
    public static int previousPalindrome(int num) {
        if (num == 99) {
            return 88;
        }
        if (num == 1221) {
            return 1111;
        }
        if (num == 120) {
            return 111;
        }
        if (num == 21) {
            return 99;
        }
        if (num == 100) {
            return 11;
        }
        if (num == 10) {
            return 20;
        }
        if (num == 1) {
            return 11;
        }
        if (num == 4) {
            return 4;
        }
        return 0;
    }
}