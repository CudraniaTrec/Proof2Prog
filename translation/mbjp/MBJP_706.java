import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class IsSubset {
    /**
     * * Write a function to find whether an array is subset of another array.
     *
     * > isSubset([11, 1, 13, 21, 3, 7], 6, [11, 3, 7, 1], 4)
     * true
     * > isSubset([1, 2, 3, 4, 5, 6], 6, [1, 2, 4], 3)
     * true
     * > isSubset([10, 5, 2, 23, 19], 5, [19, 5, 3], 3)
     * false
     */
    public static Boolean isSubset(List<Integer> arr1, int m, List<Integer> arr2, int n) {
        if (arr1.size() != m || arr2.size() != n) {
            return false;
        }

        int sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr1.get(i) == arr2.get(j)) {
                    sum += arr1.get(i) == arr2.get(j) ? 1 : 0;
                }
            }
        }
        return sum == n;
    }
}