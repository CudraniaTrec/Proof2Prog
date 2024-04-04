import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MinJumps {
    /**
     * * ## write a function to find the minimum number of jumps to reach the end of the array for the given array of integers where each element represents the max number of steps that can be made forward from that element. > indented block > indented block
     *
     * > minJumps([1, 3, 6, 1, 0, 9], 6)
     * 3
     * > minJumps([1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9], 11)
     * 3
     * > minJumps([1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1], 11)
     * 10
     */
    public static int minJumps(List<Integer> arr, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr.get(j) >= i - j) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n - 1];
    }
}