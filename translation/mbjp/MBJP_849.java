import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class Sum {
    /**
     * * Write a Java function to find sum of all prime divisors of a given number.
     *
     * > sum(60)
     * 10
     * > sum(39)
     * 16
     * > sum(40)
     * 7
     */
    public static int sum(int n) {
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                sum += i;
                while (n % i == 0) {
                    n = n / i;
                }
            }
        }
        return sum;
    }
}