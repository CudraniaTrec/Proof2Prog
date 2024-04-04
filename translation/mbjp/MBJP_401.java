import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class AddNestedTuples {
    /**
     * * Write a function to perform index wise addition of tuple elements in the given two nested tuples.
     *
     * > addNestedTuples([[1, 3], [4, 5], [2, 9], [1, 10]], [[6, 7], [3, 9], [1, 1], [7, 3]])
     * [[7, 10], [7, 14], [3, 10], [8, 13]]
     * > addNestedTuples([[2, 4], [5, 6], [3, 10], [2, 11]], [[7, 8], [4, 10], [2, 2], [8, 4]])
     * [[9, 12], [9, 16], [5, 12], [10, 15]]
     * > addNestedTuples([[3, 5], [6, 7], [4, 11], [3, 12]], [[8, 9], [5, 11], [3, 3], [9, 5]])
     * [[11, 14], [11, 18], [7, 14], [12, 17]]
     */
    public static List<List<Integer>> addNestedTuples(List<List<Integer>> testTup1, List<List<Integer>> testTup2) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < testTup1.size(); i++) {
            List<Integer> testTup = new ArrayList<>();
            for (int j = 0; j < testTup1.get(i).size(); j++) {
                testTup.add(testTup1.get(i).get(j) + testTup2.get(i).get(j));
            }
            ans.add(testTup);
        }
        return ans;
    }
}