import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class UnionElements {
    /**
     * * Write a function to find the union of elements of the given tuples.
     *
     * > unionElements([3, 4, 5, 6], [5, 7, 4, 10])
     * [3, 4, 5, 6, 7, 10]
     * > unionElements([1, 2, 3, 4], [3, 4, 5, 6])
     * [1, 2, 3, 4, 5, 6]
     * > unionElements([11, 12, 13, 14], [13, 15, 16, 17])
     * [11, 12, 13, 14, 15, 16, 17]
     */
    public static List<Integer> unionElements(List<Integer> testTup1, List<Integer> testTup2) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i : testTup1) {
            if (set.add(i)) {
                result.add(i);
            }
        }
        for (int i : testTup2) {
            if (set.add(i)) {
                result.add(i);
            }
        }
        return result;
    }
}