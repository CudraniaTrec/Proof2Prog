import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindMaxLength {
    /**
     * * Write a Java function to find the maximum length of sublist.
     *
     * > findMaxLength([[1], [1, 4], [5, 6, 7, 8]])
     * 4
     * > findMaxLength([[0, 1], [2, 2], [3, 2, 1]])
     * 3
     * > findMaxLength([[7], [22, 23], [13, 14, 15], [10, 20, 30, 40, 50]])
     * 5
     */
    public static int findMaxLength(List<List<Integer>> lst) {
        int length = 0;
        for (List<Integer> list : lst) {
            if (list.size() > length) {
                length = list.size();
            }
        }
        return length;
    }
}