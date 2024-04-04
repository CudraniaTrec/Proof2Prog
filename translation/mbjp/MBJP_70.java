import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class GetEqual {
    /**
     * * Write a function to find whether all the given tuples have equal length or not.
     *
     * > getEqual([[11, 22, 33], [44, 55, 66]], 3)
     * "All tuples have same length"
     * > getEqual([[1, 2, 3], [4, 5, 6, 7]], 3)
     * "All tuples do not have same length"
     * > getEqual([[1, 2], [3, 4]], 2)
     * "All tuples have same length"
     */
    public static String getEqual(List<List<Integer>> input, int k) {
        int sum = 0;
        for (List<Integer> list : input) {
            for (Integer value : list) {
                sum = sum + value;
            }
        }
        StringBuilder ans = new StringBuilder();
        if (sum % k == 0) {
            ans.append("All tuples have same length");
        } else {
            ans.append("All tuples do not have same length");
        }
        return ans.toString();
    }
}