import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class LcsOfThree {
    /**
     * * Write a function to find the longest common subsequence for the given three string sequence.
     *
     * > lcsOfThree("AGGT12", "12TXAYB", "12XBA", 6, 7, 5)
     * 2
     * > lcsOfThree("Reels", "Reelsfor", "ReelsforReels", 5, 8, 13)
     * 5
     * > lcsOfThree("abcd1e2", "bc12ea", "bd1ea", 7, 6, 5)
     * 3
     */
    public static int lcsOfThree(String x, String y, String z, int m, int n, int o) {
        int[][][] dp = new int[m+1][n+1][o+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= o; k++) {
                    if (x.charAt(i-1) == y.charAt(j-1) && x.charAt(i-1) == z.charAt(k-1)) {
                        dp[i][j][k] = 1 + dp[i-1][j-1][k-1];
                    } else {
                        dp[i][j][k] = Math.max(dp[i][j-1][k], Math.max(dp[i-1][j][k], dp[i][j][k-1]));
                    }
                }
            }
        }
        return dp[m][n][o];
    }
}