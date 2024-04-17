import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MaxPathSum {
    /**
     * * Write a function to find the maximum total path sum in the given triangle.
     *
     * > maxPathSum([[1, 0, 0], [4, 8, 0], [1, 5, 3]], 2, 2)
     * 14
     * > maxPathSum([[13, 0, 0], [7, 4, 0], [2, 4, 6]], 2, 2)
     * 24
     * > maxPathSum([[2, 0, 0], [11, 18, 0], [21, 25, 33]], 2, 2)
     * 53
     */
    public static int maxPathSum(List<List<Integer>> tri, int m, int n) {
        for (int row = m - 1; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                tri.get(row).set(col, tri.get(row).get(col) + Math.max(tri.get(row + 1).get(col), tri.get(row + 1).get(col + 1)));
            }
        }
        return tri.get(0).get(0);
    }
}