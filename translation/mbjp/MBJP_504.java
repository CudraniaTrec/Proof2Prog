import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SumOfSeries {
    /**
     * * Write a Java function to find the cube sum of first n natural numbers.
     *
     * > sumOfSeries(5)
     * 225
     * > sumOfSeries(2)
     * 9
     * > sumOfSeries(3)
     * 36
     */
    public static int sumOfSeries(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result += i * i * i;
        }
        return result;
    }
}