import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MaxSubArraySum {
    /**
     * * Write a function to find the largest sum of contiguous subarray in the given array.
     *
     * > maxSubArraySum([-2, -3, 4, -1, -2, 1, 5, -3], 8)
     * 7
     * > maxSubArraySum([-3, -4, 5, -2, -3, 2, 6, -4], 8)
     * 8
     * > maxSubArraySum([-4, -5, 6, -3, -4, 3, 7, -5], 8)
     * 10
     */
    public static int maxSubArraySum(List<Integer> a, int size) {
        if (size == 0) {
            return 0;
        }
        int max_sum = a.get(0);
        int local_sum = a.get(0);
        for (int i = 1; i < size; i++) {
            local_sum = Math.max(local_sum + a.get(i), a.get(i));
            max_sum = Math.max(max_sum, local_sum);
        }
        return max_sum;
    }
}