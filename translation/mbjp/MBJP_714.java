import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CountFac {
    /**
     * * Write a Java function to count the number of distinct power of prime factor of given number.
     *
     * > countFac(24)
     * 3
     * > countFac(12)
     * 2
     * > countFac(4)
     * 1
     */
    public static int countFac(int n) {
        int count = 0;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                count++;
            }
        }
        return count;
    }
}