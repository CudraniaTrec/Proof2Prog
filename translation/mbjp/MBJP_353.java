import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class RemoveColumn {
    /**
     * * Write a function to remove a specified column from a given nested list.
     *
     * > removeColumn([[1, 2, 3], [2, 4, 5], [1, 1, 1]], 0)
     * [[2, 3], [4, 5], [1, 1]]
     * > removeColumn([[1, 2, 3], [-2, 4, -5], [1, -1, 1]], 2)
     * [[1, 2], [-2, 4], [1, -1]]
     * > removeColumn([[1, 3], [5, 7], [1, 3], [13, 15, 17], [5, 7], [9, 11]], 0)
     * [[3], [7], [3], [15, 17], [7], [11]]
     */
    public static List<List<Integer>> removeColumn(List<List<Integer>> list1, int n) {
        List<List<Integer>> list2 = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            List<Integer> list = new ArrayList<>(list1.get(i));
            list.remove(n);
            list2.add(list);
        }
        return list2;
    }
}