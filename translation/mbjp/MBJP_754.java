import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ExtractIndexList {
    /**
     * * Write a function to find common index elements from three lists.
     *
     * > extractIndexList([1, 1, 3, 4, 5, 6, 7], [0, 1, 2, 3, 4, 5, 7], [0, 1, 2, 3, 4, 5, 7])
     * [1, 7]
     * > extractIndexList([1, 1, 3, 4, 5, 6, 7], [0, 1, 2, 3, 4, 6, 5], [0, 1, 2, 3, 4, 6, 7])
     * [1, 6]
     * > extractIndexList([1, 1, 3, 4, 6, 5, 6], [0, 1, 2, 3, 4, 5, 7], [0, 1, 2, 3, 4, 5, 7])
     * [1, 5]
     */
    public static List<Integer> extractIndexList(List<Integer> l1, List<Integer> l2, List<Integer> l3) {
        List<Integer> result = new ArrayList<>();
        int i = 0;
        while (i < l1.size() && i < l2.size() && i < l3.size()) {
            if (l1.get(i) == l2.get(i)) {
                result.add(l1.get(i));
                i++;
            } else {
                i++;
            }
        }
        return result;
    }
}