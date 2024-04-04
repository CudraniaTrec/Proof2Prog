import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SpecifiedElement {
    /**
     * * Write a function to extract every first or specified element from a given two-dimensional list.
     *
     * > specifiedElement([[1, 2, 3, 2], [4, 5, 6, 2], [7, 1, 9, 5]], 0)
     * [1, 4, 7]
     * > specifiedElement([[1, 2, 3, 2], [4, 5, 6, 2], [7, 1, 9, 5]], 2)
     * [3, 6, 9]
     * > specifiedElement([[1, 2, 3, 2], [4, 5, 6, 2], [7, 1, 9, 5]], 1)
     * [2, 5, 1]
     */
    public static List<Integer> specifiedElement(List<List<Integer>> nums, int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            list.add(nums.get(i).get(n));
        }
        return list;
    }
}