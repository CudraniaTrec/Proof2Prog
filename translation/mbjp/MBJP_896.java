import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SortListLast {
    /**
     * * Write a function to sort a list in increasing order by the last element in each tuple from a given list of non-empty tuples.
     *
     * > sortListLast([[2, 5], [1, 2], [4, 4], [2, 3], [2, 1]])
     * [[2, 1], [1, 2], [2, 3], [4, 4], [2, 5]]
     * > sortListLast([[9, 8], [4, 7], [3, 5], [7, 9], [1, 2]])
     * [[1, 2], [3, 5], [4, 7], [9, 8], [7, 9]]
     * > sortListLast([[20, 50], [10, 20], [40, 40]])
     * [[10, 20], [40, 40], [20, 50]]
     */
    public static List<List<Integer>> sortListLast(List<List<Integer>> tuples) {
        if (tuples.size() == 0) {
            return tuples;
        }
        Collections.sort(tuples, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(o1.size() - 1).compareTo(o2.get(o2.size() - 1));
            }
        });
        return tuples;
    }
}