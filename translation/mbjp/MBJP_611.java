import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MaxOfNth {
    /**
     * * Write a function to find the maximum of nth column from the given tuple list.
     *
     * > maxOfNth([[5, 6, 7], [1, 3, 5], [8, 9, 19]], 2)
     * 19
     * > maxOfNth([[6, 7, 8], [2, 4, 6], [9, 10, 20]], 1)
     * 10
     * > maxOfNth([[7, 8, 9], [3, 5, 7], [10, 11, 21]], 1)
     * 11
     */
    public static int maxOfNth(List<List<Integer>> testList, int n) {
        int max = 0;
        for (int i = 0; i < testList.size(); i++) {
            if (testList.get(i).size() > n) {
                max = Math.max(max, testList.get(i).get(n));
            }
        }
        return max;
    }
}