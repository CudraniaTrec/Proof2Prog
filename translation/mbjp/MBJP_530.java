import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class NegativeCount {
    /**
     * * Write a function to find the ration of negative numbers in an array of integers.
     *
     * > negativeCount([0, 1, 2, -1, -5, 6, 0, -3, -2, 3, 4, 6, 8])
     * 0.31
     * > negativeCount([2, 1, 2, -1, -5, 6, 4, -3, -2, 3, 4, 6, 8])
     * 0.31
     * > negativeCount([2, 4, -6, -9, 11, -12, 14, -5, 17])
     * 0.44
     */
    public static Double negativeCount(List<Integer> nums) {
        int size = nums.size();
        int pos = 0;
        for (int i = 0; i < size; i++) {
            if (nums.get(i) < 0) {
                pos += 1;
            }
        }
        double x = 1.0 * pos / size;
        return Double.parseDouble(String.format("%.2f", x));
    }
}