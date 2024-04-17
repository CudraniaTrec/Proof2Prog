import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class HarmonicSum {
    /**
     * * Write a function to calculate the harmonic sum of n-1.
     *
     * > harmonicSum(10)
     * 2.9289682539682538
     * > harmonicSum(4)
     * 2.083333333333333
     * > harmonicSum(7)
     * 2.5928571428571425
     */
    public static Double harmonicSum(int n) {
        double sum = 0.0;
        for (double i = 1.0; i <= n; i++) {
            sum += 1 / i;
        }
        return sum;
    }
}