import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindMinSum {
    /**
     * * Write a Java function to find minimum sum of factors of a given number.
     *
     * > findMinSum(12)
     * 7
     * > findMinSum(105)
     * 15
     * > findMinSum(2)
     * 2
     */
    public static int findMinSum(int num) {
        int i = 2, sum = 0;
        while (num > 1) {
            while (num % i == 0) {
                sum += i;
                num /= i;
            }
            i++;
        }
        return sum;
    }
}