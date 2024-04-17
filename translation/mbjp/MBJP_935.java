import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SeriesSum {
    /**
     * * Write a function to calculate the sum of series 1²+2²+3²+….+n².
     *
     * > seriesSum(6)
     * 91
     * > seriesSum(7)
     * 140
     * > seriesSum(12)
     * 650
     */
    public static int seriesSum(int number) {
        int sum = 0;
        for (int i = 1; i <= number; i++) {
            sum += i * i;
        }
        return sum;
    }
}