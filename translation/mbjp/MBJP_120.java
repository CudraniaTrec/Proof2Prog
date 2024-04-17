import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MaxProductTuple {
    /**
     * * Write a function to find the maximum product from the pairs of tuples within a given list.
     *
     * > maxProductTuple([[2, 7], [2, 6], [1, 8], [4, 9]])
     * 36
     * > maxProductTuple([[10, 20], [15, 2], [5, 10]])
     * 200
     * > maxProductTuple([[11, 44], [10, 15], [20, 5], [12, 9]])
     * 484
     */
    public static int maxProductTuple(List<List<Integer>> list1) {
        int max = 0;
        for (List<Integer> pair : list1) {
            max = Math.max(max, pair.get(0) * pair.get(1));
        }
        return max;
    }
}