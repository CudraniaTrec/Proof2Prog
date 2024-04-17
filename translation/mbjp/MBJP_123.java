import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class AmicableNumbersSum {
    /**
     * * Write a function to sum all amicable numbers from 1 to a specified number.
     *
     * > amicableNumbersSum(999)
     * 504
     * > amicableNumbersSum(9999)
     * 31626
     * > amicableNumbersSum(99)
     * 0
     */
    public static int amicableNumbersSum(int limit) {
        if (limit < 1) return 0;
        int sum = 0;
        for (int i = 2; i < limit; i++) {
            int sumOfFactors = 0;
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    sumOfFactors += j;
                }
            }
            int sumOfFactors2 = 0;
            for (int j = 1; j < sumOfFactors; j++) {
                if (sumOfFactors % j == 0) {
                    sumOfFactors2 += j;
                }
            }
            if (i == sumOfFactors2 && i != sumOfFactors) {
                sum += i;
            }
        }
        return sum;
    }
}