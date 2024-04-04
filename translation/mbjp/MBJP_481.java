import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class IsSubsetSum {
    /**
     * * Write a function to determine if there is a subset of the given set with sum equal to the given sum.
     *
     * > isSubsetSum([3, 34, 4, 12, 5, 2], 6, 9)
     * true
     * > isSubsetSum([3, 34, 4, 12, 5, 2], 6, 30)
     * false
     * > isSubsetSum([3, 34, 4, 12, 5, 2], 6, 15)
     * true
     */
    public static Boolean isSubsetSum(List<Integer> set, int n, int sum) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (set.get(i) + set.get(j) == sum) {
                    return true;
                }
            }
        }
        return false;
    }
}