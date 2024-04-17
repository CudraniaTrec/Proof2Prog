import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SpecifiedElement {
    /**
     * * Write a function to extract every specified element from a given two dimensional list.
     *
     * > specifiedElement([[1, 2, 3, 2], [4, 5, 6, 2], [7, 1, 9, 5]], 0)
     * [1, 4, 7]
     * > specifiedElement([[1, 2, 3, 2], [4, 5, 6, 2], [7, 1, 9, 5]], 2)
     * [3, 6, 9]
     * > specifiedElement([[1, 2, 3, 2], [4, 5, 6, 2], [7, 1, 9, 5]], 3)
     * [2, 2, 5]
     */
    public static List<Integer> specifiedElement(List<List<Integer>> nums, int n) {
        if (nums == null || nums.size() == 0) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < nums.size(); i++) {
            result.add(nums.get(i).get(n));
        }
        return result;
    }
}