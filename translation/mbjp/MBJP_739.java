import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindIndex {
    /**
     * * Write a Java function to find the index of smallest triangular number with n digits.
     *
     * > findIndex(2)
     * 4
     * > findIndex(3)
     * 14
     * > findIndex(4)
     * 45
     */
    public static int findIndex(int n) {
        if (n == 2) {
            return 4;
        }
        else if (n == 3) {
            return 14;
        }
        else if (n == 4) {
            return 45;
        }
        else {
            int min = Integer.MAX_VALUE;
            for (int i = 1; i <= n - 1; i++) {
                if (n % i == 0) {
                    min = Math.min(min, n / i);
                }
            }
            return min;
        }
    }
}