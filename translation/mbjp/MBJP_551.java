import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ExtractColumn {
    /**
     * * Write a function to extract a specified column from a given nested list.
     *
     * > extractColumn([[1, 2, 3], [2, 4, 5], [1, 1, 1]], 0)
     * [1, 2, 1]
     * > extractColumn([[1, 2, 3], [-2, 4, -5], [1, -1, 1]], 2)
     * [3, -5, 1]
     * > extractColumn([[1, 3], [5, 7], [1, 3], [13, 15, 17], [5, 7], [9, 11]], 0)
     * [1, 5, 1, 13, 5, 9]
     */
    public static List<Integer> extractColumn(List<List<Integer>> list1, int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            list.add(list1.get(i).get(n));
        }
        return list;
    }
}