import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class PairWise {
    /**
     * * Write a function to iterate over all pairs of consecutive items in a given list.
     *
     * > pairWise([1, 1, 2, 3, 3, 4, 4, 5])
     * [[1, 1], [1, 2], [2, 3], [3, 3], [3, 4], [4, 4], [4, 5]]
     * > pairWise([1, 5, 7, 9, 10])
     * [[1, 5], [5, 7], [7, 9], [9, 10]]
     * > pairWise([1, 2, 3, 4, 5, 6, 7, 8, 9, 10])
     * [[1, 2], [2, 3], [3, 4], [4, 5], [5, 6], [6, 7], [7, 8], [8, 9], [9, 10]]
     */
    public static List<List<Integer>> pairWise(List<Integer> l1) {
        LinkedList<Integer> n1 = new LinkedList<>(l1);
        List<List<Integer>> ret = new LinkedList<>();
        for (int i = 1; i < n1.size(); i++) {
            List<Integer> curr = new ArrayList<>();
            curr.add(n1.get(i-1));
            curr.add(n1.get(i));
            ret.add(curr);
        }
        return ret;
    }
}