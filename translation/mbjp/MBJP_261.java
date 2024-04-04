import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class DivisionElements {
    /**
     * * Write a function to perform mathematical division operation across the given tuples.
     *
     * > divisionElements([10, 4, 6, 9], [5, 2, 3, 3])
     * [2, 2, 2, 3]
     * > divisionElements([12, 6, 8, 16], [6, 3, 4, 4])
     * [2, 2, 2, 4]
     * > divisionElements([20, 14, 36, 18], [5, 7, 6, 9])
     * [4, 2, 6, 2]
     */
    public static List<Integer> divisionElements(List<Integer> testTup1, List<Integer> testTup2) {
        List<Integer> result = new ArrayList<>();
        int res;
        int left = 0;
        int right = 0;
        while (left < testTup1.size() && right < testTup2.size()) {
            res = testTup1.get(left) / testTup2.get(right);
            result.add(res);
            left++;
            right++;
        }
        return result;
    }
}