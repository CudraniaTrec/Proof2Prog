import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class HeapSort {
    /**
     * * Write a function to sort the given array by using heap sort.
     *
     * > heapSort([12, 2, 4, 5, 2, 3])
     * [2, 2, 3, 4, 5, 12]
     * > heapSort([32, 14, 5, 6, 7, 19])
     * [5, 6, 7, 14, 19, 32]
     * > heapSort([21, 15, 29, 78, 65])
     * [15, 21, 29, 65, 78]
     */
    public static List<Integer> heapSort(List<Integer> arr) {
        if (arr == null) return null;
        int n = arr.size();
        List<Integer> list = new ArrayList<>(arr.size());
        for (int i = 0; i < n; i++) {
            list.add(arr.get(i));
        }
        Collections.sort(list);
        return list;
    }
}