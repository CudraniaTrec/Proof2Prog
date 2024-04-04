import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class HeapQueueLargest {
    /**
     * * Write a function to find the largest integers from a given list of numbers using heap queue algorithm.
     *
     * > heapQueueLargest([25, 35, 22, 85, 14, 65, 75, 22, 58], 3)
     * [85, 75, 65]
     * > heapQueueLargest([25, 35, 22, 85, 14, 65, 75, 22, 58], 2)
     * [85, 75]
     * > heapQueueLargest([25, 35, 22, 85, 14, 65, 75, 22, 58], 5)
     * [85, 75, 65, 58, 35]
     */
    public static List<Integer> heapQueueLargest(List<Integer> nums, int n) {
        List<Integer> l = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.size(); i++) {
            pq.offer(nums.get(i));
        }
        for (int i = 0; i < n; i++) {
            l.add(pq.poll());
        }
        return l;
    }
}