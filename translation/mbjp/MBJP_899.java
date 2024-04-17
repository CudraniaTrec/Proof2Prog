import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class Check {
    /**
     * * Write a Java function to check whether an array can be sorted or not by picking only the corner elements.
     *
     * > check([3, 2, 1, 2, 3, 4], 6)
     * true
     * > check([2, 1, 4, 5, 1], 5)
     * true
     * > check([1, 2, 2, 1, 2, 3], 6)
     * true
     */
    public static Boolean check(List<Integer> arr, int n) {
        List<Integer> temp = new ArrayList<>();
        boolean has = true;
        int[] tempArr = new int[n];
        for (int i = 0; i < n; i++) {
            if (arr.get(i) != 0) {
                tempArr[i] = arr.get(i);
            } else {
                tempArr[i] = 0;
            }
        }
        boolean isSorted = false;
        for (int i = 0; i < n; i++) {
            if (!temp.contains(tempArr[i])) {
                isSorted = true;
                break;
            }
        }
        return isSorted;
    }
}