import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class Sum {
    /**
     * * Write a Java function to find the sum of common divisors of two given numbers.
     *
     * > sum(10, 15)
     * 6
     * > sum(100, 150)
     * 93
     * > sum(4, 6)
     * 3
     */
    public static int sum(int a, int b) {
        int sum = 0;
        for (int i = 1; i <= a && i <= b; i++) {
            if (a % i == 0 && b % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
}