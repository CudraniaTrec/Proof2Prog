import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MaxSum {
    /**
     * * Write a function to find the maximum sum in the given right triangle of numbers.
     *
     * > maxSum([[1], [2, 1], [3, 3, 2]], 3)
     * 6
     * > maxSum([[1], [1, 2], [4, 1, 12]], 3)
     * 15
     * > maxSum([[2], [3, 2], [13, 23, 12]], 3)
     * 28
     */
    public static int maxSum(List<List<Integer>> tri, int n) {
        // Write your code here
        int [][] t = new int [n][n];
        for(int i=0; i < n; i++) {
            for(int j=0; j <= i; j++) {
                t[i][j] = tri.get(i).get(j);
            }
        }

        for(int i=n-2; i >= 0; i--) {
            for(int j=0; j <= i; j++) {
                if(t[i+1][j] + t[i][j] > t[i+1][j+1]) {
                    t[i][j] = t[i+1][j] + t[i][j];
                }
                else {
                    t[i][j] = t[i+1][j+1] + t[i][j];
                }
            }
        }
        return (t[0][0]);
    }
}