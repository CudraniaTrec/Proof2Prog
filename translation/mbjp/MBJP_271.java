import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class EvenPowerSum {
    /**
     * * Write a Java function to find the sum of fifth power of first n even natural numbers.
     *
     * > evenPowerSum(2)
     * 1056
     * > evenPowerSum(3)
     * 8832
     * > evenPowerSum(1)
     * 32
     */
    public static int evenPowerSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int j = 2 * i;
            sum += j * j * j * j * j;
        }
        return sum;
    }
}