import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CommonInNestedLists {
    /**
     * * Write a function to find common elements in given nested lists. * list item * list item * list item * list item
     *
     * > commonInNestedLists([[12, 18, 23, 25, 45], [7, 12, 18, 24, 28], [1, 5, 8, 12, 15, 16, 18]])
     * [18, 12]
     * > commonInNestedLists([[12, 5, 23, 25, 45], [7, 11, 5, 23, 28], [1, 5, 8, 18, 23, 16]])
     * [5, 23]
     * > commonInNestedLists([[2, 3, 4, 1], [4, 5], [6, 4, 8], [4, 5], [6, 8, 4]])
     * [4]
     */
    public static List<Integer> commonInNestedLists(List<List<Integer>> nestedlist) {
        List<Integer> result = new ArrayList<>();
        if (nestedlist == null) {
            return result;
        }
        result = new ArrayList<>(new HashSet<>(nestedlist.get(0)));
        for (int i = 1; i < nestedlist.size(); i++) {
            result.retainAll(nestedlist.get(i));
        }
        return result;
    }
}