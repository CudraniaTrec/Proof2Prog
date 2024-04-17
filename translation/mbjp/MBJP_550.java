import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindMax {
    /**
     * * Write a Java function to find the maximum element in a sorted and rotated array.
     *
     * > findMax([2, 3, 5, 6, 9], 0, 4)
     * 9
     * > findMax([3, 4, 5, 2, 1], 0, 4)
     * 5
     * > findMax([1, 2, 3], 0, 2)
     * 3
     */
    public static int findMax(List<Integer> arr, int low, int high) {
        int max = 0;
        for (int i = low; i <= high; i++) {
            max = Math.max(max, arr.get(i));
        }
        return max;
    }
}