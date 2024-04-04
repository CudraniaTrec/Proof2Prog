import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CountNoOfWays {
    /**
     * * Write a function to find out the number of ways of painting the fence such that at most 2 adjacent posts have the same color for the given fence with n posts and k colors.
     *
     * > countNoOfWays(2, 4)
     * 16
     * > countNoOfWays(3, 2)
     * 6
     * > countNoOfWays(4, 4)
     * 228
     */
    public static int countNoOfWays(int n, int k) {
        int[] memo = new int[n + 1];
        memo[0] = k;
        memo[1] = k;
        memo[2] = k * k;
        for (int i = 3; i <= n; i++) {
            memo[i] = ((k - 1) * memo[i - 1]) % 1000000007 + ((k - 1) * memo[i - 2]) % 1000000007;
        }
        return memo[n];
    }
}