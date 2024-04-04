import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CountPairs {
    /**
     * * Write a Java function to count equal element pairs from the given array.
     *
     * > countPairs([1, 1, 1, 1], 4)
     * 6
     * > countPairs([1, 5, 1], 3)
     * 1
     * > countPairs([3, 2, 1, 7, 8, 9], 6)
     * 0
     */
    public static int countPairs(List<Integer> arr, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr.get(i) == arr.get(j)) {
                    count++;
                }
            }
        }
        return count;
    }
}