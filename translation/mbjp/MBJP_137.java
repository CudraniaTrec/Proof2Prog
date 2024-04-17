import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ZeroCount {
    /**
     * * Write a function to find the ration of zeroes in an array of integers.
     *
     * > zeroCount([0, 1, 2, -1, -5, 6, 0, -3, -2, 3, 4, 6, 8])
     * 0.15
     * > zeroCount([2, 1, 2, -1, -5, 6, 4, -3, -2, 3, 4, 6, 8])
     * 0.0
     * > zeroCount([2, 4, -6, -9, 11, -12, 14, -5, 17])
     * 0.0
     */
    public static Double zeroCount(List<Integer> nums) {
        int counter = 0;
        for (int num : nums) {
            counter += num == 0 ? 1 : 0;
        }
        double ratio = ((double) counter) / nums.size();
        return Math.floor(ratio * 100) / 100.0;
    }
}