import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class RecurGcd {
    /**
     * * Write a function to find the greatest common divisor (gcd) of two integers by using recursion.
     *
     * > recurGcd(12, 14)
     * 2
     * > recurGcd(13, 17)
     * 1
     * > recurGcd(9, 3)
     * 3
     */
    public static int recurGcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        return recurGcd(a % b, b % a);
    }
}