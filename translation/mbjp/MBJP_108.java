import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MergeSortedList {
    /**
     * * Write a function to merge multiple sorted inputs into a single sorted iterator using heap queue algorithm.
     *
     * > mergeSortedList([25, 24, 15, 4, 5, 29, 110], [19, 20, 11, 56, 25, 233, 154], [24, 26, 54, 48])
     * [4, 5, 11, 15, 19, 20, 24, 24, 25, 25, 26, 29, 48, 54, 56, 110, 154, 233]
     * > mergeSortedList([1, 3, 5, 6, 8, 9], [2, 5, 7, 11], [1, 4, 7, 8, 12])
     * [1, 1, 2, 3, 4, 5, 5, 6, 7, 7, 8, 8, 9, 11, 12]
     * > mergeSortedList([18, 14, 10, 9, 8, 7, 9, 3, 2, 4, 1], [25, 35, 22, 85, 14, 65, 75, 25, 58], [12, 74, 9, 50, 61, 41])
     * [1, 2, 3, 4, 7, 8, 9, 9, 9, 10, 12, 14, 14, 18, 22, 25, 25, 35, 41, 50, 58, 61, 65, 74, 75, 85]
     */
    public static List<Integer> mergeSortedList(List<Integer> num1, List<Integer> num2, List<Integer> num3) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < num1.size(); i++) {
            minHeap.add(num1.get(i));
        }
        for (int i = 0; i < num2.size(); i++) {
            minHeap.add(num2.get(i));
        }
        for (int i = 0; i < num3.size(); i++) {
            minHeap.add(num3.get(i));
        }
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }
        return result;
    }
}