import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindPeak {
    /**
     * * Write a function to find the peak element in the given array.
     *
     * > findPeak([1, 3, 20, 4, 1, 0], 6)
     * 2
     * > findPeak([2, 3, 4, 5, 6], 5)
     * 4
     * > findPeak([8, 9, 11, 12, 14, 15], 6)
     * 5
     */
    public static int findPeak(List<Integer> arr, int n) {
        if (n <= 0 || arr.size() != n)
            return 0;
        int m = 0;
        for (int i = 0; i < n; i++) {
            if (arr.get(m) < arr.get(i)) {
                m++;
            }
        }
        return m;
    }
}