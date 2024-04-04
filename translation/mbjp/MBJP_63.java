import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MaxDifference {
    /**
     * * Write a function to find the maximum difference between available pairs in the given tuple list.
     *
     * > maxDifference([[3, 5], [1, 7], [10, 3], [1, 2]])
     * 7
     * > maxDifference([[4, 6], [2, 17], [9, 13], [11, 12]])
     * 15
     * > maxDifference([[12, 35], [21, 27], [13, 23], [41, 22]])
     * 23
     */
    public static int maxDifference(List<List<Integer>> testList) {
        int max = Integer.MIN_VALUE;
        for (List<Integer> list : testList) {
            int maxdiff = 0;
            for (int i : list) {
                for (int j : list) {
                    maxdiff = Math.max(maxdiff, Math.abs(i - j));
                }
            }
            max = Math.max(max, maxdiff);
        }
        return max;
    }
}