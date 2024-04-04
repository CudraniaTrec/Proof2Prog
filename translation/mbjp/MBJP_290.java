import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MaxLength {
    /**
     * * Write a function to find the list of lists with maximum length.
     *
     * > maxLength([[0], [1, 3], [5, 7], [9, 11], [13, 15, 17]])
     * [3, [13, 15, 17]]
     * > maxLength([[1], [5, 7], [10, 12, 14, 15]])
     * [4, [10, 12, 14, 15]]
     * > maxLength([[5], [15, 20, 25]])
     * [3, [15, 20, 25]]
     */
    public static List<Object> maxLength(List<List<Integer>> list1) {
        // write your code here
        if (list1 == null || list1.size() == 0) return new ArrayList<>();
        int minlength = list1.get(0).size();
        for (int i = 1; i < list1.size(); i++) {
            int cur = list1.get(i).size();
            if (cur > minlength) minlength = cur;
        }
        List<Object> res = new ArrayList<>();
        res.add(minlength);
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).size() == minlength) {
                res.add(list1.get(i));
            }
        }
        return res;
    }
}