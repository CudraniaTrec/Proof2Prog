import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindMax {
    /**
     * * Write a function to find the maximum element of all the given tuple records.
     *
     * > findMax([[2, 4], [6, 7], [5, 1], [6, 10], [8, 7]])
     * 10
     * > findMax([[3, 5], [7, 8], [6, 2], [7, 11], [9, 8]])
     * 11
     * > findMax([[4, 6], [8, 9], [7, 3], [8, 12], [10, 9]])
     * 12
     */
    public static int findMax(List<List<Integer>> testList) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (List<Integer> testList1 : testList) {
            for (int i : testList1) {
                if (!freq.containsKey(i)) {
                    freq.put(i, 0);
                } else {
                    freq.put(i, freq.get(i) + 1);
                }
            }
        }
        int max = 0;
        for (Integer key : freq.keySet()) {
            max = Math.max(key, freq.get(key));
        }
        return max;
    }
}