import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindMaxVal {
    /**
     * * Write a function to find the largest possible value of k such that k modulo x is y.
     *
     * > findMaxVal(15, 10, 5)
     * 15
     * > findMaxVal(187, 10, 5)
     * 185
     * > findMaxVal(16, 11, 1)
     * 12
     */
    public static int findMaxVal(int n, int x, int y) {
        // write your code here
        int max = 0;
        for (int i = n; i >= 1; i--) {
            int mod = i % x;
            if (mod == 0 || mod == y) {
                max = Math.max(max, i);
            }
        }
        return max;
    }
}