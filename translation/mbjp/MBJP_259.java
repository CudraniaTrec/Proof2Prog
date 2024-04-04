import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MaximizeElements {
    /**
     * * Write a function to maximize the given two tuples.
     *
     * > maximizeElements([[1, 3], [4, 5], [2, 9], [1, 10]], [[6, 7], [3, 9], [1, 1], [7, 3]])
     * [[6, 7], [4, 9], [2, 9], [7, 10]]
     * > maximizeElements([[2, 4], [5, 6], [3, 10], [2, 11]], [[7, 8], [4, 10], [2, 2], [8, 4]])
     * [[7, 8], [5, 10], [3, 10], [8, 11]]
     * > maximizeElements([[3, 5], [6, 7], [4, 11], [3, 12]], [[8, 9], [5, 11], [3, 3], [9, 5]])
     * [[8, 9], [6, 11], [4, 11], [9, 12]]
     */
    public static List<List<Integer>> maximizeElements(List<List<Integer>> testTup1, List<List<Integer>> testTup2) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < testTup1.size(); i++) {
            List<Integer> temp1 = testTup1.get(i);
            List<Integer> temp2 = testTup2.get(i);
            List<Integer> ans = new ArrayList<Integer>();
            for (int j = 0; j < temp1.size(); j++) {
                int temp1x = temp1.get(j);
                int temp2x = temp2.get(j);
                int temp = Math.max(temp1x, temp2x);
                ans.add(temp);
            }
            res.add(ans);
        }
        return res;
    }
}