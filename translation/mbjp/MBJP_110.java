import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ExtractMissing {
    /**
     * * Write a function to extract the ranges that are missing from the given list with the given start range and end range values.
     *
     * > extractMissing([[6, 9], [15, 34], [48, 70]], 2, 100)
     * [[2, 6], [9, 100], [9, 15], [34, 100], [34, 48], [70, 100]]
     * > extractMissing([[7, 2], [15, 19], [38, 50]], 5, 60)
     * [[5, 7], [2, 60], [2, 15], [19, 60], [19, 38], [50, 60]]
     * > extractMissing([[7, 2], [15, 19], [38, 50]], 1, 52)
     * [[1, 7], [2, 52], [2, 15], [19, 52], [19, 38], [50, 52]]
     */
    public static List<List<Integer>> extractMissing(List<List<Integer>> testList, int strtVal, int stopVal) {
        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> sub : testList) {
            if (sub.get(0) > strtVal) {
                List<Integer> range = new ArrayList<>();
                range.add(strtVal);
                range.add(sub.get(0));
                res.add(range);
                strtVal = sub.get(1);
            }
            if (strtVal < stopVal) {
                res.add(new ArrayList<>(Arrays.asList(strtVal, stopVal)));
            }
        }
        return res;
    }
}