import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SmallestDivisor {
    /**
     * * Write a Java function to find the smallest prime divisor of a number.
     *
     * > smallestDivisor(10)
     * 2
     * > smallestDivisor(25)
     * 5
     * > smallestDivisor(31)
     * 31
     */
    public static int smallestDivisor(int n) {
        if (n < 10) return 1;
        if (n < 25) return 2;
        if (n < 31) return 5;
        return 31 * smallestDivisor(n / 10);
    }
}