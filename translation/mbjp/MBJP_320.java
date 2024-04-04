import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SumDifference {
    /**
     * * Write a function to calculate the difference between the squared sum of first n natural numbers and the sum of squared first n natural numbers.
     *
     * > sumDifference(12)
     * 5434
     * > sumDifference(20)
     * 41230
     * > sumDifference(54)
     * 2151270
     */
    public static int sumDifference(int n) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i <= n; i++) {
            sum1 += i;
            sum2 += (i * i);
        }
        int diff = (int) (Math.pow(sum1, 2) - sum2);
        return diff;
    }
}