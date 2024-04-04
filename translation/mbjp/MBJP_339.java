import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindDivisor {
    /**
     * * Write a Java function to find the maximum occuring divisor in an interval.
     *
     * > findDivisor(2, 2)
     * 2
     * > findDivisor(2, 5)
     * 2
     * > findDivisor(5, 10)
     * 2
     */
    public static int findDivisor(int x, int y) {
        if (x == 0) {
            return 0;
        } else if (x == y) {
            return x;
        } else if (x % y == 0) {
            return 1;
        } else {
            return 2;
        }
    }
}