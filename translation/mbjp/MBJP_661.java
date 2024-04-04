import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MaxSumOfThreeConsecutive {
    /**
     * * Write a function to find the maximum sum that can be formed which has no three consecutive elements present.
     *
     * > maxSumOfThreeConsecutive([100, 1000, 100, 1000, 1], 5)
     * 2101
     * > maxSumOfThreeConsecutive([3000, 2000, 1000, 3, 10], 5)
     * 5013
     * > maxSumOfThreeConsecutive([1, 2, 3, 4, 5, 6, 7, 8], 8)
     * 27
     */
    public static int maxSumOfThreeConsecutive(List<Integer> arr, int n) {
        int[] sums = new int[n];
        sums[0] = arr.get(0);
        sums[1] = arr.get(0) + arr.get(1);
        if (n >= 2) {
            sums[2] = Math.max(sums[1], arr.get(1) + arr.get(2));
        }
        for (int i = 3; i < n; i++) {
            sums[i] = Math.max(
                Math.max(sums[i - 1], sums[i - 2] + arr.get(i)),
                arr.get(i) + arr.get(i - 1) + sums[i - 3]
            );
        }
        return sums[n - 1];
    }
}