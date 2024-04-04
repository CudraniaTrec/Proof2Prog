import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindLength {
    /**
     * * Write a function to find the maximum difference between the number of 0s and number of 1s in any sub-string of the given binary string.
     *
     * > findLength("11000010001", 11)
     * 6
     * > findLength("10111", 5)
     * 1
     * > findLength("11011101100101", 14)
     * 2
     */
    public static int findLength(String string, int n) {
        int max = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += string.charAt(i) == '0' ? 1 : -1;
            max = Math.max(max, count);
            if (count < 0) {
                count = 0;
            }
        }
        return max;
    }
}