import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MaxSumRectangularGrid {
    /**
     * * Write a function to find out the maximum sum such that no two chosen numbers are adjacent for the given rectangular grid of dimension 2 x n.
     *
     * > maxSumRectangularGrid([[1, 4, 5], [2, 0, 0]], 3)
     * 7
     * > maxSumRectangularGrid([[1, 2, 3, 4, 5], [6, 7, 8, 9, 10]], 5)
     * 24
     * > maxSumRectangularGrid([[7, 9, 11, 15, 19], [21, 25, 28, 31, 32]], 5)
     * 81
     */
    public static int maxSumRectangularGrid(List<List<Integer>> grid, int n) {
        int incl = Math.max(grid.get(0).get(0), grid.get(1).get(0));
        int excl = Math.min(grid.get(0).get(n - 1), grid.get(1).get(n - 1));
        for (int i = 1; i < n; i++) {
            int incl_new = Math.max(excl, incl);
            incl = excl + Math.max(grid.get(0).get(i), grid.get(1).get(i));
            excl = incl_new;
        }
        return Math.max(excl, incl);
    }
}