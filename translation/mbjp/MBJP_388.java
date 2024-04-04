import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class HighestPowerOf2 {
    /**
     * * Write a Java function to find the highest power of 2 that is less than or equal to n.
     *
     * > highestPowerOf2(10)
     * 8
     * > highestPowerOf2(19)
     * 16
     * > highestPowerOf2(32)
     * 32
     */
    public static int highestPowerOf2(int n) {
        if (n == 0) {
            return 0;
        }

        int high = 1;
        while (high <= n / 2) {
            high = high * 2;
        }
        return high;
    }
}