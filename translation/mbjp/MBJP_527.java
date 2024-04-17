import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class GetPairsCount {
    /**
     * * Write a function to find all pairs in an integer array whose sum is equal to a given number.
     *
     * > getPairsCount([1, 5, 7, -1, 5], 5, 6)
     * 3
     * > getPairsCount([1, 5, 7, -1], 4, 6)
     * 2
     * > getPairsCount([1, 1, 1, 1], 4, 2)
     * 6
     */
    public static int getPairsCount(List<Integer> arr, int n, int sum) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            int pairCount = 0;
            for (int j = i + 1; j < n; j++) {
                if (arr.get(i) + arr.get(j) == sum) {
                    pairCount++;
                }
            }
            count += pairCount;
        }
        return count;
    }
}