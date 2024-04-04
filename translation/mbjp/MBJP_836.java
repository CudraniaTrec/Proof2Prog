import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MaxSubArraySum {
    /**
     * * Write a function to find length of the subarray having maximum sum.
     *
     * > maxSubArraySum([-2, -3, 4, -1, -2, 1, 5, -3], 8)
     * 5
     * > maxSubArraySum([1, -2, 1, 1, -2, 1], 6)
     * 2
     * > maxSubArraySum([-1, -2, 3, 4, 5], 5)
     * 3
     */
    public static int maxSubArraySum(List<Integer> a, int size) {
        int max = 0;
        int currentSum = 0;
        int tempMax = 0;
        for (int i = 0; i < a.size(); i++) {
            currentSum += a.get(i);
            tempMax = Math.max(tempMax, currentSum);
            max = Math.max(max, tempMax - currentSum);
            if (currentSum >= size)
                currentSum = tempMax;
        }
        return max;
    }
}