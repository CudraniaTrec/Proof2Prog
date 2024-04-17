import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SumGp {
    /**
     * * Write a function to find the sum of geometric progression series.
     *
     * > sumGp(1, 5, 2)
     * 31
     * > sumGp(1, 5, 4)
     * 341
     * > sumGp(2, 6, 3)
     * 728
     */
    public static int sumGp(int a, int n, int r) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a * Math.pow(r, i);
        }
        return sum;
    }
}