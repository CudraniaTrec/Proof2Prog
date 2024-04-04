import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MaximumSegments {
    /**
     * * Write a function to find the maximum number of segments of lengths a, b and c that can be formed from n.
     *
     * > maximumSegments(7, 5, 2, 5)
     * 2
     * > maximumSegments(17, 2, 1, 3)
     * 17
     * > maximumSegments(18, 16, 3, 6)
     * 6
     */
    public static int maximumSegments(int n, int a, int b, int c) {
        int[] dp = new int[n + 10];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i < n; i += 1) {
            if (dp[i] != -1) {
                if (i + a <= n) {
                    dp[i + a] = Math.max(dp[i] + 1, dp[i + a]);
                }
                if (i + b <= n) {
                    dp[i + b] = Math.max(dp[i] + 1, dp[i + b]);
                }
                if (i + c <= n) {
                    dp[i + c] = Math.max(dp[i] + 1, dp[i + c]);
                }
            }
        }
        return dp[n];
    }
}