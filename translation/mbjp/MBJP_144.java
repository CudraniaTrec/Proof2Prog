import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SumPairs {
    /**
     * * Write a Java function to find the sum of absolute differences in all pairs of the given array.
     *
     * > sumPairs([1, 8, 9, 15, 16], 5)
     * 74
     * > sumPairs([1, 2, 3, 4], 4)
     * 10
     * > sumPairs([1, 2, 3, 4, 5, 7, 9, 11, 14], 9)
     * 188
     */
    public static int sumPairs(List<Integer> arr, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                sum += Math.abs(arr.get(i) - arr.get(j));
            }
        }
        return sum;
    }
}