import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MaxPrimeFactors {
    /**
     * * Write a Java function to find the largest prime factor of a given number.
     *
     * > maxPrimeFactors(15)
     * 5
     * > maxPrimeFactors(6)
     * 3
     * > maxPrimeFactors(2)
     * 2
     */
    public static int maxPrimeFactors(int n) {
        int res = 2;
        // Check first
        if (n <= 1) {
            return res;
        }
        // First prime
        int nextPrime = 2;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return n / i;
            } else {
                res = maxPrimeFactors(nextPrime);
                nextPrime = nextPrime + 1;
            }
        }
        // Next prime
        nextPrime = 1;
        for (int i = 2; i < n - 1; i++) {
            if (n % i == 0) {
                return n / i;
            } else {
                return n / i + 1;
            }
        }
        // Nothing found
        return res;
    }
}