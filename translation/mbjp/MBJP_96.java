import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class Divisor {
    /**
     * * Write a Java function to find the number of divisors of a given integer.
     *
     * > divisor(15)
     * 4
     * > divisor(12)
     * 6
     * > divisor(9)
     * 3
     */
    public static int divisor(int n) {
        int divisor = 1;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                divisor++;
            }
        }
        return divisor;
    }
}