import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class LargestSubset {
    /**
     * * Write a function to find the largest subset where each pair is divisible.
     *
     * > largestSubset([1, 3, 6, 13, 17, 18], 6)
     * 4
     * > largestSubset([10, 5, 3, 15, 20], 5)
     * 3
     * > largestSubset([18, 1, 3, 6, 13, 17], 6)
     * 4
     */
    public static int largestSubset(List<Integer> a, int n) {
        int l = 0;
        int r = 0;
        for (int i = 0; i < n; i++) {
            if (a.get(i) % 2 == 0) {
                l = l + 1;
            } else {
                r = r + 1;
            }
        }
        return l > r ? l : r;
    }
}