import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SdCalc {
    /**
     * * Write a function to calculate the standard deviation.
     *
     * > sdCalc([4, 2, 5, 8, 6])
     * 2.23606797749979
     * > sdCalc([1, 2, 3, 4, 5, 6, 7])
     * 2.160246899469287
     * > sdCalc([5, 9, 10, 15, 6, 4])
     * 4.070217029430577
     */
    public static Double sdCalc(List<Integer> data) {
        double sum = 0, mean = 0;
        for (Integer d : data) {
            sum += d;
        }
        mean = sum / data.size();
        double variance = 0;
        for (Integer d : data) {
            double diff = d - mean;
            variance += diff * diff;
        }
        variance /= data.size() - 1;
        return Math.sqrt(variance);
    }
}