import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SumSeries {
    /**
     * * Write a function to calculate the sum of series 1³+2³+3³+….+n³.
     *
     * > sumSeries(7)
     * 784
     * > sumSeries(5)
     * 225
     * > sumSeries(15)
     * 14400
     */
    public static int sumSeries(int number) {
        if (number <= 0) return 0;
        if (number == 1) return 1;
        return sumSeries(number - 1) + number * number * number;
    }
}