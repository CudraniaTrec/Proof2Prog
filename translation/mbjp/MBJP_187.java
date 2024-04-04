import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class LongestCommonSubsequence {
    /**
     * * Write a function to find the longest common subsequence for the given two sequences.
     *
     * > longestCommonSubsequence("AGGTAB", "GXTXAYB", 6, 7)
     * 4
     * > longestCommonSubsequence("ABCDGH", "AEDFHR", 6, 6)
     * 3
     * > longestCommonSubsequence("AXYT", "AYZX", 4, 4)
     * 2
     */
    public static int longestCommonSubsequence(String x, String y, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}