import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CoinChange {
    /**
     * * Write a function to count coin change.
     *
     * > coinChange([1, 2, 3], 3, 4)
     * 4
     * > coinChange([4, 5, 6, 7, 8, 9], 6, 9)
     * 2
     * > coinChange([4, 5, 6, 7, 8, 9], 6, 4)
     * 1
     */
    public static int coinChange(List<Integer> s, int m, int n) {
        if (s == null || s.size() == 0) return 0;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                if (s.get(j) <= i) {
                    dp[i] = Math.max(dp[i], dp[i - s.get(j)] + 1);
                }
            }
        }
        return dp[n];
    }
}