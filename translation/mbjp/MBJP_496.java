import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class HeapQueueSmallest {
    /**
     * * Write a function to find the smallest integers from a given list of numbers using heap queue algorithm.
     *
     * > heapQueueSmallest([25, 35, 22, 85, 14, 65, 75, 25, 58], 3)
     * [14, 22, 25]
     * > heapQueueSmallest([25, 35, 22, 85, 14, 65, 75, 25, 58], 2)
     * [14, 22]
     * > heapQueueSmallest([25, 35, 22, 85, 14, 65, 75, 22, 58], 5)
     * [14, 22, 22, 25, 35]
     */
    public static List<Integer> heapQueueSmallest(List<Integer> nums, int n) {
        if (nums == null || nums.isEmpty() || nums.size() == 0) {
            return Collections.emptyList();
        }
        List<Integer> list = new ArrayList<Integer>();
        Collections.sort(nums);
        for (int i = 0; i < n; i++) {
            list.add(nums.get(i));
        }
        return list;
    }
}