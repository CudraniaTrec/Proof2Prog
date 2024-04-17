import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MinSumPath {
    /**
     * * Write a function to find the minimum total path sum in the given triangle.
     *
     * > minSumPath([[2], [3, 9], [1, 6, 7]])
     * 6
     * > minSumPath([[2], [3, 7], [8, 5, 6]])
     * 10
     * > minSumPath([[3], [6, 4], [5, 2, 7]])
     * 9
     */
    public static int minSumPath(List<List<Integer>> a) {
        // write your code here
        int[] dp = new int[a.size()];
        dp[0] = a.get(0).get(0);
        for (int i = 1; i < a.size(); i++) {
            dp[i] = Math.min(dp[i - 1] + a.get(i).get(0), dp[i - 1] + a.get(i).get(1));
        }

        return dp[dp.length - 1];
    }
}