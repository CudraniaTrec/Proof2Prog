import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindMissing {
    /**
     * * Write a Java function to find the missing number in a sorted array.
     *
     * > findMissing([1, 2, 3, 5], 4)
     * 4
     * > findMissing([1, 3, 4, 5], 4)
     * 2
     * > findMissing([1, 2, 3, 5, 6, 7], 5)
     * 4
     */
    public static int findMissing(List<Integer> ar, int n) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int i = 0;
        while (i < ar.size() && freq.getOrDefault(ar.get(i), 0) < n) {
            freq.put(ar.get(i), freq.getOrDefault(ar.get(i), 0) + 1);
            i++;
        }
        for (int j = 1; j <= n; j++) {
            if (freq.getOrDefault(j, 0) == 0) {
                return j;
            }
        }
        return 0;
    }
}