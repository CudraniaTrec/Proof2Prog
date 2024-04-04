import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CheckMinHeap {
    /**
     * * Write a function to check if the given array represents min heap or not.
     *
     * > checkMinHeap([1, 2, 3, 4, 5, 6], 0)
     * true
     * > checkMinHeap([2, 3, 4, 5, 10, 15], 0)
     * true
     * > checkMinHeap([2, 10, 4, 5, 3, 15], 0)
     * false
     */
    public static Boolean checkMinHeap(List<Integer> arr, int i) {
        int curMin = arr.get(i);
        // Find min size
        int size = arr.size();
        int start = curMin;
        while (curMin > 1) {
            if (size < arr.get(curMin - 1) || curMin + 1 > size) {
                return false;
            }
            curMin--;
        }
        return true;
    }
}