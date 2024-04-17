import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class IsSubArray {
    /**
     * * Write a Java function to check whether an array is subarray of another or not.
     *
     * > isSubArray([1, 4, 3, 5], [1, 2], 4, 2)
     * false
     * > isSubArray([1, 2, 1], [1, 2, 1], 3, 3)
     * true
     * > isSubArray([1, 0, 2, 2], [2, 2, 0], 4, 3)
     * false
     */
    public static Boolean isSubArray(List<Integer> a, List<Integer> b, int n, int m) {
        if (n < m) {
            return false;
        }
        if (a.size() != b.size()) {
            return false;
        }
        for (int i = 0; i < m; i++) {
            if (a.get(i) != b.get(i)) {
                return false;
            }
        }
        return true;
    }
}