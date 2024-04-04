import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FlattenList {
    /**
     * * Write a function to flatten a given nested list structure.
     *
     * > flattenList([0, 10, [20, 30], 40, 50, [60, 70, 80], [90, 100, 110, 120]])
     * [0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120]
     * > flattenList([[10, 20], [40], [30, 56, 25], [10, 20], [33], [40]])
     * [10, 20, 40, 30, 56, 25, 10, 20, 33, 40]
     * > flattenList([[1, 2, 3], [4, 5, 6], [10, 11, 12], [7, 8, 9]])
     * [1, 2, 3, 4, 5, 6, 10, 11, 12, 7, 8, 9]
     */
    public static List<Integer> flattenList(List<Object> list1) {
        List<Integer> list2 = new ArrayList<>();
        for (Object o : list1) {
            if (o instanceof List) {
                list2.addAll((List<Integer>) o);
            }
            else if (o instanceof Integer) {
                list2.add((Integer) o);
            }
        }
        return list2;
    }
}