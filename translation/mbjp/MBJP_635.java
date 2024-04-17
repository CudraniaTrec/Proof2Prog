import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class HeapSort {
    /**
     * * Write a function to push all values into a heap and then pop off the smallest values one at a time.
     *
     * > heapSort([1, 3, 5, 7, 9, 2, 4, 6, 8, 0])
     * [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
     * > heapSort([25, 35, 22, 85, 14, 65, 75, 25, 58])
     * [14, 22, 25, 25, 35, 58, 65, 75, 85]
     * > heapSort([7, 1, 9, 5])
     * [1, 5, 7, 9]
     */
    public static List<Integer> heapSort(List<Integer> iterable) {
        List<Integer> sorted = new ArrayList<>();
        for (int i = 0; i < iterable.size(); i++) {
            sorted.add(iterable.get(i));
        }
        Collections.sort(sorted);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < sorted.size(); i++) {
            result.add(sorted.get(i));
        }
        return result;
    }
}