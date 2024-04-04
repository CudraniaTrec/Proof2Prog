import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MaxSubArraySumRepeated {
    /**
     * * Write a function to find the largest sum of contiguous array in the modified array which is formed by repeating the given array k times.
     *
     * > maxSubArraySumRepeated([10, 20, -30, -1], 4, 3)
     * 30
     * > maxSubArraySumRepeated([-1, 10, 20], 3, 2)
     * 59
     * > maxSubArraySumRepeated([-1, -2, -3], 3, 3)
     * -1
     */
    public static int maxSubArraySumRepeated(List<Integer> a, int n, int k) {
        int max = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a.get(i);
        }
        max = sum;
        for (int i = 0; i < n; i++) {
            if (i >= k) {
                sum -= a.get(i - k);
            }
            if (sum < 0) {
                sum = 0;
            }
            sum += a.get(i);
            max = Math.max(max, sum);
        }
        return max;
    }
}