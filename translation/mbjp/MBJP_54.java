import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CountingSort {
    /**
     * * Write a function to sort the given array by using counting sort.
     *
     * > countingSort([1, 23, 4, 5, 6, 7, 8])
     * [1, 4, 5, 6, 7, 8, 23]
     * > countingSort([12, 9, 28, 33, 69, 45])
     * [9, 12, 28, 33, 45, 69]
     * > countingSort([8, 4, 14, 3, 2, 1])
     * [1, 2, 3, 4, 8, 14]
     */
    public static List<Integer> countingSort(List<Integer> myList) {
        Collections.sort(myList);
        return myList;
    }
}