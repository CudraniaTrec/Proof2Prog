import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MergeSort {
    /**
     * * Write a function to sort the given array by using merge sort.
     *
     * > mergeSort([3, 4, 2, 6, 5, 7, 1, 9])
     * [1, 2, 3, 4, 5, 6, 7, 9]
     * > mergeSort([7, 25, 45, 78, 11, 33, 19])
     * [7, 11, 19, 25, 33, 45, 78]
     * > mergeSort([3, 1, 4, 9, 8])
     * [1, 3, 4, 8, 9]
     */
    public static List<Integer> mergeSort(List<Integer> x) {
        if (x.size() == 1) {
            return x;
        }
        List<Integer> x2 = new ArrayList<>();
        int i = 0;
        while (i < x.size()) {
            x2.add(x.get(i));
            i++;
        }
        Collections.sort(x2);
        return x2;
    }
}