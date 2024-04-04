import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class Lps {
    /**
     * * Write a function to find the longest palindromic subsequence in the given string.
     *
     * > lps("TENS FOR TENS")
     * 5
     * > lps("CARDIO FOR CARDS")
     * 7
     * > lps("PART OF THE JOURNEY IS PART")
     * 9
     */
    public static int lps(String str) {
        int n = str.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}