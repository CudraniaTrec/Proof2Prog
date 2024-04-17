import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindDiff {
    /**
     * * Write a Java function to find the difference between highest and least frequencies in a given array.
     *
     * > findDiff([1, 1, 2, 2, 7, 8, 4, 5, 1, 4], 10)
     * 2
     * > findDiff([1, 7, 9, 2, 3, 3, 1, 3, 3], 9)
     * 3
     * > findDiff([1, 2, 1, 2], 4)
     * 0
     */
    public static int findDiff(List<Integer> arr, int n) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < arr.size(); i++) {
            freq.put(arr.get(i), freq.getOrDefault(arr.get(i), 0) + 1);
        }

        int minFreq = Integer.MAX_VALUE;
        int maxFreq = Integer.MIN_VALUE;

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
            }
            if (entry.getValue() < minFreq) {
                minFreq = entry.getValue();
            }
        }
        return (maxFreq - minFreq);
    }
}