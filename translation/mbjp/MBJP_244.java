import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class NextPerfectSquare {
    /**
     * * Write a Java function to find the next perfect square greater than a given number.
     *
     * > nextPerfectSquare(35)
     * 36
     * > nextPerfectSquare(6)
     * 9
     * > nextPerfectSquare(9)
     * 16
     */
    public static int nextPerfectSquare(int n) {
        if (n < 1) {
            return -1;
        }
        int i = 1, s = n;
        while (i * i <= s) {
            i++;
        }
        return i * i;
    }
}