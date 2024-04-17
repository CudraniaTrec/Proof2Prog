import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindMinDiff {
    /**
     * * Write a Java function to find the minimum difference between any two elements in a given array.
     *
     * > findMinDiff([1, 5, 3, 19, 18, 25], 6)
     * 1
     * > findMinDiff([4, 3, 2, 6], 4)
     * 1
     * > findMinDiff([30, 5, 20, 9], 4)
     * 4
     */
    public static int findMinDiff(List<Integer> arr, int n) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                min = Math.min(min, Math.abs(arr.get(i) - arr.get(j)));
            }
        }
        return min;
    }
}