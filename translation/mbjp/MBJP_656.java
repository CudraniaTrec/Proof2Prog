import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindMinSum {
    /**
     * * Write a Java function to find the minimum sum of absolute differences of two arrays.
     *
     * > findMinSum([3, 2, 1], [2, 1, 3], 3)
     * 0
     * > findMinSum([1, 2, 3], [4, 5, 6], 3)
     * 9
     * > findMinSum([4, 1, 8, 7], [2, 3, 6, 5], 4)
     * 6
     */
    public static int findMinSum(List<Integer> a, List<Integer> b, int n) {
        int[] a1 = new int[n];
        int[] b1 = new int[n];
        for (int i = 0; i < n; i++) {
            a1[i] = a.get(i);
            b1[i] = b.get(i);
        }
        Arrays.sort(a1);
        Arrays.sort(b1);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.abs(a1[i] - b1[i]);
        }
        return sum;
    }
}