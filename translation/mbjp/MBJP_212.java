import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FourthPowerSum {
    /**
     * * Write a Java function to find the sum of fourth power of n natural numbers.
     *
     * > fourthPowerSum(2)
     * 17
     * > fourthPowerSum(4)
     * 354
     * > fourthPowerSum(6)
     * 2275
     */
    public static int fourthPowerSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += (int) Math.pow(i, 4);
        }
        return sum;
    }
}