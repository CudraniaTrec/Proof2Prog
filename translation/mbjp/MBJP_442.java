import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class PositiveCount {
    /**
     * * Write a function to find the ration of positive numbers in an array of integers.
     *
     * > positiveCount([0, 1, 2, -1, -5, 6, 0, -3, -2, 3, 4, 6, 8])
     * 0.54
     * > positiveCount([2, 1, 2, -1, -5, 6, 4, -3, -2, 3, 4, 6, 8])
     * 0.69
     * > positiveCount([2, 4, -6, -9, 11, -12, 14, -5, 17])
     * 0.56
     */
    public static Double positiveCount(List<Integer> nums) {
        int count = 0;
        for (int i : nums) {
            count += i > 0 ? 1 : 0;
        }
        return Math.round((double) count / nums.size() * 100.0) / 100.0;
    }
}