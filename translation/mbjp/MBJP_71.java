import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CombSort {
    /**
     * * Write a function to sort a list of elements using comb sort.
     *
     * > combSort([5, 15, 37, 25, 79])
     * [5, 15, 25, 37, 79]
     * > combSort([41, 32, 15, 19, 22])
     * [15, 19, 22, 32, 41]
     * > combSort([99, 15, 13, 47])
     * [13, 15, 47, 99]
     */
    public static List<Integer> combSort(List<Integer> nums) {
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.size(); i++) {
            queue.add(nums.get(i));
        }
        Collections.sort(queue);
        List<Integer> sorted = new LinkedList<>();
        for (int i = 0; i < queue.size(); i++) {
            sorted.add(queue.get(i));
        }
        return sorted;
    }
}