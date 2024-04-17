import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class Lbs {
    /**
     * * Write a function to find the longest bitonic subsequence for the given array.
     *
     * > lbs([0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15])
     * 7
     * > lbs([1, 11, 2, 10, 4, 5, 2, 1])
     * 6
     * > lbs([80, 60, 30, 40, 20, 10])
     * 5
     */
    public static int lbs(List<Integer> arr) {
        int n = arr.size();
        int[] l = new int[n];
        int[] r = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            l[i] = 1;
            r[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr.get(i) > arr.get(j)) {
                    l[i] = Math.max(l[i], l[j] + 1);
                }
                if (arr.get(i) < arr.get(j)) {
                    r[i] = Math.max(r[i], r[j] + 1);
                }
            }
            max = Math.max(max, l[i] + r[i] - 1);
        }
        return max;
    }
}