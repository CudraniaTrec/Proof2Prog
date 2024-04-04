import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ExtractMinMax {
    /**
     * * Write a function to extract maximum and minimum k elements in the given tuple.
     *
     * > extractMinMax([5, 20, 3, 7, 6, 8], 2)
     * [3, 5, 8, 20]
     * > extractMinMax([4, 5, 6, 1, 2, 7], 3)
     * [1, 2, 4, 5, 6, 7]
     * > extractMinMax([2, 3, 4, 8, 9, 11, 7], 4)
     * [2, 3, 4, 7, 8, 9, 11]
     */
    public static List<Integer> extractMinMax(List<Integer> testTup, int k) {
        List<Integer> res = new ArrayList<Integer>();
        List<Integer> temp = new ArrayList<Integer>(testTup);
        temp.sort(Comparator.naturalOrder());
        for (int i = 0; i < temp.size(); i++) {
            if (i < k || i >= temp.size() - k) {
                res.add(temp.get(i));
            }
        }
        return res;
    }
}