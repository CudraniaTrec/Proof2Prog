import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class Gcd {
    /**
     * * Write a Java function to find gcd of two positive integers.
     *
     * > gcd(12, 17)
     * 1
     * > gcd(4, 6)
     * 2
     * > gcd(2, 9)
     * 1
     */
    public static int gcd(int x, int y) {
        if (x == 0) {
            return y;
        }
        return gcd(x % y, y % x);
    }
}