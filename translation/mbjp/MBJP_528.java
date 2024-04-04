import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MinLength {
    /**
     * * Write a function to find the list of lists with minimum length.
     *
     * > minLength([[0], [1, 3], [5, 7], [9, 11], [13, 15, 17]])
     * [1, [0]]
     * > minLength([[1], [5, 7], [10, 12, 14, 15]])
     * [1, [1]]
     * > minLength([[5], [15, 20, 25]])
     * [1, [5]]
     */
    public static List<Object> minLength(List<List<Integer>> list1) {
        List<Object> result = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list1.size(); i++) {
            min = Math.min(min, list1.get(i).size());
        }
        result.add(min);
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).size() == min) {
                result.add(list1.get(i));
            }
        }
        return result;
    }
}