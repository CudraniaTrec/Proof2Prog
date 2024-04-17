import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MaxSumSubseq {
    /**
     * * Write a function to find the maximum sum of subsequences of given array with no adjacent elements.
     *
     * > maxSumSubseq([1, 2, 9, 4, 5, 0, 4, 11, 6])
     * 26
     * > maxSumSubseq([1, 2, 9, 5, 6, 0, 5, 12, 7])
     * 28
     * > maxSumSubseq([1, 3, 10, 5, 6, 0, 6, 14, 21])
     * 44
     */
    public static int maxSumSubseq(List<Integer> a) {
        int size = a.size();
        int sum = 0, maxSum = Integer.MIN_VALUE;
        int prevSum = 0, currSum = 0;
        for (int i = 0; i < size; i++) {
            currSum = prevSum + a.get(i);
            prevSum = sum;
            sum = Math.max(sum, currSum);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}