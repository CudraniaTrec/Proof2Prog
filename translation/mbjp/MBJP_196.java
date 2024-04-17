import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class RemoveTuples {
    /**
     * * Write a function to remove all the tuples with length k.
     *
     * > removeTuples([[4, 5], [4], [8, 6, 7], [1], [3, 4, 6, 7]], 1)
     * [[4, 5], [8, 6, 7], [3, 4, 6, 7]]
     * > removeTuples([[4, 5], [4, 5], [6, 7], [1, 2, 3], [3, 4, 6, 7]], 2)
     * [[1, 2, 3], [3, 4, 6, 7]]
     * > removeTuples([[1, 4, 4], [4, 3], [8, 6, 7], [1], [3, 6, 7]], 3)
     * [[4, 3], [1]]
     */
    public static List<List<Integer>> removeTuples(List<List<Integer>> testList, int k) {
        if (testList == null || testList.size() == 0) {
            return null;
        }
        ArrayList<List<Integer>> outList = new ArrayList<List<Integer>>();
        for (List<Integer> list : testList) {
            if (list.size() != k) {
                outList.add(list);
            }
        }
        return outList;
    }
}