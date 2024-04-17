import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CountPairs {
    /**
     * * Write a Java function to count unequal element pairs from the given array.
     *
     * > countPairs([1, 2, 1], 3)
     * 2
     * > countPairs([1, 1, 1, 1], 4)
     * 0
     * > countPairs([1, 2, 3, 4, 5], 5)
     * 10
     */
    public static int countPairs(List<Integer> arr, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr.get(j) != arr.get(i)) {
                    count++;
                }
            }
        }
        return count;
    }
}