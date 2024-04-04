import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CalSum {
    /**
     * * Write a function to calculate the sum of perrin numbers.
     *
     * > calSum(9)
     * 49
     * > calSum(10)
     * 66
     * > calSum(11)
     * 88
     */
    public static int calSum(int n) {
        int a = 3;
        int b = 0;
        int c = 2;
        int sum = 5;
        if (n == 0) {
            return 3;
        }
        if (n == 1) {
            return 3;
        }
        if (n == 2) {
            return 5;
        }
        while (n > 2) {
            int d = a + b;
            sum = sum + d;
            a = b;
            b = c;
            c = d;
            n = n - 1;
        }
        return sum;
    }
}