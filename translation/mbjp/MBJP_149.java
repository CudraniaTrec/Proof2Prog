import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class LongestSubseqWithDiffOne {
    /**
     * * Write a function to find the longest subsequence such that the difference between adjacents is one for the given array.
     *
     * > longestSubseqWithDiffOne([1, 2, 3, 4, 5, 3, 2], 7)
     * 6
     * > longestSubseqWithDiffOne([10, 9, 4, 5, 4, 8, 6], 7)
     * 3
     * > longestSubseqWithDiffOne([1, 2, 3, 2, 3, 7, 2, 1], 8)
     * 7
     */
    public static int longestSubseqWithDiffOne(List<Integer> arr, int n) {
        int diff = 0;
        int max = 0;
        for (int i = 0; i < arr.size(); i++) {
            diff = Math.abs(arr.get(i) - n);
            if (diff > max) {
                max = diff;
            }
        }
        return max;
    }
}