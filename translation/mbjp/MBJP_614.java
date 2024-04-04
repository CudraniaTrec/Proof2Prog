import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CummulativeSum {
    /**
     * * Write a function to find the cumulative sum of all the values that are present in the given tuple list.
     *
     * > cummulativeSum([[1, 3], [5, 6, 7], [2, 6]])
     * 30
     * > cummulativeSum([[2, 4], [6, 7, 8], [3, 7]])
     * 37
     * > cummulativeSum([[3, 5], [7, 8, 9], [4, 8]])
     * 44
     */
    public static int cummulativeSum(List<List<Integer>> testList) {
        int sum = 0;
        int n = testList.size();
        for (int i = 0; i < n; i++) {
            List<Integer> list = testList.get(i);
            for (int j = 0; j < list.size(); j++) {
                sum += list.get(j);
            }
        }
        return sum;
    }
}