import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class AverageOdd {
    /**
     * * Write a Java function to find the average of odd numbers till a given odd number.
     *
     * > averageOdd(9)
     * 5
     * > averageOdd(5)
     * 3
     * > averageOdd(11)
     * 6
     */
    public static int averageOdd(int n) {
        if (n == 1) return 0;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum / n;
    }
}