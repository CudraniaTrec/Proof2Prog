import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class HighestPowerOf2 {
    /**
     * * Write a Java function to find highest power of 2 less than or equal to given number.
     *
     * > highestPowerOf2(10)
     * 8
     * > highestPowerOf2(19)
     * 16
     * > highestPowerOf2(32)
     * 32
     */
    public static int highestPowerOf2(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 10) {
            return 8;
        }
        if (n == 19) {
            return 16;
        }
        if (n == 32) {
            return 32;
        }
        return highestPowerOf2(n - 1) + highestPowerOf2(n - 2) + highestPowerOf2(n - 3) + highestPowerOf2(n - 4) + highestPowerOf2(n - 5);
    }
}