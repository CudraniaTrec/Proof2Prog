import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class IndexMultiplication {
    /**
     * * Write a function to perform index wise multiplication of tuple elements in the given two tuples.
     *
     * > indexMultiplication([[1, 3], [4, 5], [2, 9], [1, 10]], [[6, 7], [3, 9], [1, 1], [7, 3]])
     * [[6, 21], [12, 45], [2, 9], [7, 30]]
     * > indexMultiplication([[2, 4], [5, 6], [3, 10], [2, 11]], [[7, 8], [4, 10], [2, 2], [8, 4]])
     * [[14, 32], [20, 60], [6, 20], [16, 44]]
     * > indexMultiplication([[3, 5], [6, 7], [4, 11], [3, 12]], [[8, 9], [5, 11], [3, 3], [9, 5]])
     * [[24, 45], [30, 77], [12, 33], [27, 60]]
     */
    public static List<List<Integer>> indexMultiplication(List<List<Integer>> testTup1, List<List<Integer>> testTup2) {
        List<List<Integer>> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < testTup1.size() && j < testTup2.size()) {
            List<Integer> tup1 = testTup1.get(i);
            List<Integer> tup2 = testTup2.get(j);
            List<Integer> resultTuple = new ArrayList<>();
            for (int k = 0; k < tup1.size(); k++) {
                resultTuple.add(tup1.get(k) * tup2.get(k));
            }
            result.add(resultTuple);
            i++;
            j++;
        }
        return result;
    }
}