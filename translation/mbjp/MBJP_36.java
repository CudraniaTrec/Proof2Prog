import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindNthDigit {
    /**
     * * Write a Java function to find the nth digit in the proper fraction of two given numbers.
     *
     * > findNthDigit(1, 2, 1)
     * 5
     * > findNthDigit(3, 5, 1)
     * 6
     * > findNthDigit(5, 6, 5)
     * 3
     */
    public static int findNthDigit(int p, int q, int n) {
        int result = 0;
        while (n > 0) {
            n -= 1;
            p *= 10;
            result = Math.floorDiv(p, q);
            p = Math.floorMod(p, q);
        }
        return result;
    }
}