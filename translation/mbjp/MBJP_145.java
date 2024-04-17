import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MaxAbsDiff {
    /**
     * * Write a Java function to find the maximum difference between any two elements in a given array.
     *
     * > maxAbsDiff([2, 1, 5, 3], 4)
     * 4
     * > maxAbsDiff([9, 3, 2, 5, 1], 5)
     * 8
     * > maxAbsDiff([3, 2, 1], 3)
     * 2
     */
    public static int maxAbsDiff(List<Integer> arr, int n) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, arr.get(i) - arr.get(n - i - 1));
        }
        return result;
    }
}