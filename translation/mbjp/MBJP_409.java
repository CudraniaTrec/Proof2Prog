import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MinProductTuple {
    /**
     * * Write a function to find the minimum product from the pairs of tuples within a given list.
     *
     * > minProductTuple([[2, 7], [2, 6], [1, 8], [4, 9]])
     * 8
     * > minProductTuple([[10, 20], [15, 2], [5, 10]])
     * 30
     * > minProductTuple([[11, 44], [10, 15], [20, 5], [12, 9]])
     * 100
     */
    public static int minProductTuple(List<List<Integer>> list1) {
        int min = Integer.MAX_VALUE;
        for (List<Integer> list : list1) {
            int product = 1;
            for (int i = 0; i < list.size(); i++) {
                product *= list.get(i);
            }
            if (product < min) {
                min = product;
            }
        }
        return min;
    }
}