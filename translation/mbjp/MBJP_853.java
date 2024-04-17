import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SumOfOddFactors {
    /**
     * * Write a Java function to find sum of odd factors of a number.
     *
     * > sumOfOddFactors(30)
     * 24
     * > sumOfOddFactors(18)
     * 13
     * > sumOfOddFactors(2)
     * 1
     */
    public static int sumOfOddFactors(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i = i + 2) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
}