import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SortTuple {
    /**
     * * Write a function to sort a list of tuples in increasing order by the last element in each tuple.
     *
     * > sortTuple([[1, 3], [3, 2], [2, 1]])
     * [[2, 1], [3, 2], [1, 3]]
     * > sortTuple([[2, 4], [3, 3], [1, 1]])
     * [[1, 1], [3, 3], [2, 4]]
     * > sortTuple([[3, 9], [6, 7], [4, 3]])
     * [[4, 3], [6, 7], [3, 9]]
     */
    public static List<List<Integer>> sortTuple(List<List<Integer>> tup) {
        Collections.sort(tup, new Comparator<List<Integer>>() {

            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(o1.size() - 1) - o2.get(o2.size() - 1);
            }
        });
        return tup;
    }
}