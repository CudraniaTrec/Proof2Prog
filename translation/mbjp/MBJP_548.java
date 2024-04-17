import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class LongestIncreasingSubsequence {
    /**
     * * Write a function to find the length of the longest increasing subsequence of the given sequence.
     *
     * > longestIncreasingSubsequence([10, 22, 9, 33, 21, 50, 41, 60])
     * 5
     * > longestIncreasingSubsequence([3, 10, 2, 1, 20])
     * 3
     * > longestIncreasingSubsequence([50, 3, 10, 7, 40, 80])
     * 4
     */
    public static int longestIncreasingSubsequence(List<Integer> arr) {
        int length = arr.size();
        int[] cache = new int[length];
        Arrays.fill(cache, 1);
        int ans = 1;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr.get(i) > arr.get(j)) {
                    cache[i] = Math.max(cache[i], cache[j] + 1);
                }
            }
            ans = Math.max(ans, cache[i]);
        }
        return ans;
    }
}