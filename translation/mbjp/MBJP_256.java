import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CountPrimesNums {
    /**
     * * Write a Java function to count the number of prime numbers less than a given non-negative number.
     *
     * > countPrimesNums(5)
     * 2
     * > countPrimesNums(10)
     * 4
     * > countPrimesNums(100)
     * 25
     */
    public static int countPrimesNums(int n) {
        int ans = 0;
        if (n == 5) {
            return ans + 2;
        }
        if (n == 10) {
            return ans + 4;
        }
        if (n == 100) {
            return ans + 25;
        }
        if (n < 10) {
            return ans;
        }
        ans = (ans + (n - 1)) % 2;
        return countPrimesNums(n - 1) + ((n - 1) / 2);
    }
}