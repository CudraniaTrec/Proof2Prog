import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;

class SumSeries {
    /**
     * * Write a function to calculate the sum of the positive integers of
     * n+(n-2)+(n-4)... (until n-x =< 0).
     *
     * > sumSeries(6)
     * 12
     * > sumSeries(10)
     * 30
     * > sumSeries(9)
     * 25
     */
    public static int sumSeries(int n) {
        int sum = 0;
        for (int i = n; i > 0; i = i - 2) {
            sum += i;
        }
        return sum;
    }
}