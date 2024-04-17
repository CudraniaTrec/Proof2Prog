import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class HarmonicSum {
    /**
     * * Write a function to calculate the harmonic sum of n-1.
     *
     * > harmonicSum(7)
     * 2.5928571428571425
     * > harmonicSum(4)
     * 2.083333333333333
     * > harmonicSum(19)
     * 3.547739657143682
     */
    public static Double harmonicSum(int n) {
        double sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += 1.0 / i;
        }
        return sum;
    }
}