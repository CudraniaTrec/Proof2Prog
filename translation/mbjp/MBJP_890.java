import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindExtra {
    /**
     * * Write a Java function to find the index of an extra element present in one sorted array.
     *
     * > findExtra([1, 2, 3, 4], [1, 2, 3], 3)
     * 3
     * > findExtra([2, 4, 6, 8, 10], [2, 4, 6, 8], 4)
     * 4
     * > findExtra([1, 3, 5, 7, 9, 11], [1, 3, 5, 7, 9], 5)
     * 5
     */
    public static int findExtra(List<Integer> arr1, List<Integer> arr2, int n) {
        int i;
        int j;
        int count = 0;
        for (i = 0; i < arr1.size(); i++) {
            for (j = 0; j < arr2.size(); j++) {
                if (arr1.get(i).compareTo(arr2.get(j)) == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}