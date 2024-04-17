import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class AreEqual {
    /**
     * * Write a Java function to check whether the given two arrays are equal or not.
     *
     * > areEqual([1, 2, 3], [3, 2, 1], 3, 3)
     * true
     * > areEqual([1, 1, 1], [2, 2, 2], 3, 3)
     * false
     * > areEqual([8, 9], [4, 5, 6], 2, 3)
     * false
     */
    public static Boolean areEqual(List<Integer> arr1, List<Integer> arr2, int n, int m) {
        if (arr1 == null || arr2 == null || n < 1 || m < 1 || arr1.size() != arr2.size()) {
            return false;
        }
        boolean isEqual = false;
        for (int i = 0; i < n; i++) {
            isEqual = arr1.get(i) == arr2.get(i);
            if (!isEqual) {
                isEqual = (i == 0 || arr1.get(i - 1) == arr2.get(i - 1));
            }
        }
        return isEqual;
    }
}