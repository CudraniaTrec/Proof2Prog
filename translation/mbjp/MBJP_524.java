import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MaxSumIncreasingSubsequence {
    /**
     * * Write a function to find the sum of maximum increasing subsequence of the given array.
     *
     * > maxSumIncreasingSubsequence([1, 101, 2, 3, 100, 4, 5], 7)
     * 106
     * > maxSumIncreasingSubsequence([3, 4, 5, 10], 4)
     * 22
     * > maxSumIncreasingSubsequence([10, 5, 4, 3], 4)
     * 10
     */
    public static int maxSumIncreasingSubsequence(List<Integer> arr, int n) {
        int maxsum = 0;
        for (int i = 0; i < arr.size() && n > 0; i++) {
            int sub = arr.get(i);
            for (int j = 0; j < i; j++) {
                if (arr.get(j) < sub) {
                    sub += arr.get(j);
                }
            }
            maxsum = Math.max(maxsum, sub);
            n--;
        }
        return maxsum;
    }
}