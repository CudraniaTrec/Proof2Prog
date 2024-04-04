import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class Maxaverageofpath {
    /**
     * * Write a function to find a path with the maximum average over all existing paths for the given square matrix of size n*n.
     *
     * > maxaverageofpath([[1, 2, 3], [6, 5, 4], [7, 3, 9]], 3)
     * 5.2
     * > maxaverageofpath([[2, 3, 4], [7, 6, 5], [8, 4, 10]], 3)
     * 6.2
     * > maxaverageofpath([[3, 4, 5], [8, 7, 6], [9, 5, 11]], 3)
     * 7.2
     */
    public static Double maxaverageofpath(List<List<Integer>> cost, int n) {
        int row = cost.size();
        int col = cost.get(0).size();
        double[][] dp = new double[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                dp[i][j] = cost.get(i - 1).get(j - 1) + Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[row][col] / (2 * row - 1);
    }
}