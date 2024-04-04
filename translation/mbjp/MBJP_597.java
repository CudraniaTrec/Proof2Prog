import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindKth {
    /**
     * * Write a function to find kth element from the given two sorted arrays.
     *
     * > findKth([2, 3, 6, 7, 9], [1, 4, 8, 10], 5, 4, 5)
     * 6
     * > findKth([100, 112, 256, 349, 770], [72, 86, 113, 119, 265, 445, 892], 5, 7, 7)
     * 256
     * > findKth([3, 4, 7, 8, 10], [2, 5, 9, 11], 5, 4, 6)
     * 8
     */
    public static int findKth(List<Integer> arr1, List<Integer> arr2, int m, int n, int k) {
        int i = 0, j = 0;
        List<Integer> arr = new ArrayList<>();
        while (i < arr1.size() && j < arr2.size()) {
            if (arr1.get(i) <= arr2.get(j)) {
                arr.add(arr1.get(i));
                i++;
            } else {
                arr.add(arr2.get(j));
                j++;
            }
        }
        if (i < arr1.size()) {
            return arr.get(k - 1);
        } else {
            return arr.get(k - 1);
        }
    }
}