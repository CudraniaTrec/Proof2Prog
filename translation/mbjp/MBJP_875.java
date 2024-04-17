import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MinDifference {
    /**
     * * Write a function to find the minimum difference in the tuple pairs of given tuples.
     *
     * > minDifference([[3, 5], [1, 7], [10, 3], [1, 2]])
     * 1
     * > minDifference([[4, 6], [12, 8], [11, 4], [2, 13]])
     * 2
     * > minDifference([[5, 17], [3, 9], [12, 5], [3, 24]])
     * 6
     */
    public static int minDifference(List<List<Integer>> testList) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < testList.size(); i++) {
            for (int j = 0; j < testList.get(i).size() - 1; j++) {
                min = Math.min(min, Math.abs(testList.get(i).get(j) - testList.get(i).get(j + 1)));
            }
        }
        return min;
    }
}