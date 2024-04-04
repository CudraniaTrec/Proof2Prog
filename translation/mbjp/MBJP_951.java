import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MaxSimilarIndices {
    /**
     * * Write a function to find the maximum of similar indices in two lists of tuples.
     *
     * > maxSimilarIndices([[2, 4], [6, 7], [5, 1]], [[5, 4], [8, 10], [8, 14]])
     * [[5, 4], [8, 10], [8, 14]]
     * > maxSimilarIndices([[3, 5], [7, 8], [6, 2]], [[6, 5], [9, 11], [9, 15]])
     * [[6, 5], [9, 11], [9, 15]]
     * > maxSimilarIndices([[4, 6], [8, 9], [7, 3]], [[7, 6], [10, 12], [10, 16]])
     * [[7, 6], [10, 12], [10, 16]]
     */
    public static List<List<Integer>> maxSimilarIndices(List<List<Integer>> testList1, List<List<Integer>> testList2) {
        // Write your code here
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < testList1.size(); i++){
            List<Integer> cur = new ArrayList<>();
            cur.add(testList1.get(i).get(0));
            cur.add(testList1.get(i).get(1));
            res.add(cur);
        }

        for(int i = 0; i < testList2.size(); i++){
            List<Integer> cur = res.get(i);
            cur.set(0, Math.max(cur.get(0), testList2.get(i).get(0)));
            cur.set(1, Math.max(cur.get(1), testList2.get(i).get(1)));
        }

        return res;
    }
}