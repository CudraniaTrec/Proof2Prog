import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindMinLength {
    /**
     * * Write a Java function to find the minimum length of sublist.
     *
     * > findMinLength([[1], [1, 2]])
     * 1
     * > findMinLength([[1, 2], [1, 2, 3], [1, 2, 3, 4]])
     * 2
     * > findMinLength([[3, 3, 3], [4, 4, 4, 4]])
     * 3
     */
    public static int findMinLength(List<List<Integer>> lst) {
        int min = Integer.MAX_VALUE;
        for (List<Integer> list : lst) {
            if (list.size() < min) {
                min = list.size();
            }
        }
        return min;
    }
}