import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MaximumSum {
    /**
     * * Write a Java function to find the maximum sum of elements of list in a list of lists.
     *
     * > maximumSum([[1, 2, 3], [4, 5, 6], [10, 11, 12], [7, 8, 9]])
     * 33
     * > maximumSum([[0, 1, 1], [1, 1, 2], [3, 2, 1]])
     * 6
     * > maximumSum([[0, 1, 3], [1, 2, 1], [9, 8, 2], [0, 1, 0], [6, 4, 8]])
     * 19
     */
    public static int maximumSum(List<List<Integer>> list1) {
        int max = 0;
        for (List<Integer> list : list1) {
            int sum = 0;
            for (int i : list) {
                sum += i;
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}