import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CountPairs {
    /**
     * * Write a function to count all the distinct pairs having a difference of k in any array.
     *
     * > countPairs([1, 5, 3, 4, 2], 5, 3)
     * 2
     * > countPairs([8, 12, 16, 4, 0, 20], 6, 4)
     * 5
     * > countPairs([2, 4, 1, 3, 4], 5, 2)
     * 3
     */
    public static int countPairs(List<Integer> arr, int n, int k) {
        if (k < 1) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(i) - arr.get(j) == k || arr.get(i) - arr.get(j) == -k) {
                    count++;
                }
            }
        }
        return count;
    }
}