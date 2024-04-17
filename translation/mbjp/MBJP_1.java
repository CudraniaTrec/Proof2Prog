import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MinCost {
    /**
     * * Write a function to find the minimum cost path to reach (m, n) from (0, 0) for the given cost matrix cost[][] and a position (m, n) in cost[][].
     *
     * > minCost([[1, 2, 3], [4, 8, 2], [1, 5, 3]], 2, 2)
     * 8
     * > minCost([[2, 3, 4], [5, 9, 3], [2, 6, 4]], 2, 2)
     * 12
     * > minCost([[3, 4, 5], [6, 10, 4], [3, 7, 5]], 2, 2)
     * 16
     */
    public static int minCost(List<List<Integer>> cost, int m, int n) {
        int[][] T = new int[m+1][n+1];
        for(int i = 0 ; i < m+1; i++){
            for(int j = 0; j < n+1; j++){
                if(i == 0 && j == 0) T[i][j] = cost.get(i).get(j);
                else if(i == 0) T[i][j] = T[i][j-1] + cost.get(i).get(j);
                else if(j == 0) T[i][j] = T[i-1][j] + cost.get(i).get(j);
                else T[i][j] = Math.min(T[i-1][j-1], Math.min(T[i-1][j], T[i][j-1])) + cost.get(i).get(j);
            }
        }
        return T[m][n];
    }
}