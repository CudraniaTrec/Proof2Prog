import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ApSum {
    /**
     * * Write a function to find the sum of arithmetic progression.
     *
     * > apSum(1, 5, 2)
     * 25
     * > apSum(2, 6, 4)
     * 72
     * > apSum(1, 4, 5)
     * 34
     */
    public static int apSum(int a, int n, int d) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a;
            a = a + d;
        }
        return sum;
    }
}