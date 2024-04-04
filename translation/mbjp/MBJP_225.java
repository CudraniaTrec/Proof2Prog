import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindMin {
    /**
     * * Write a Java function to find the minimum element in a sorted and rotated array.
     *
     * > findMin([1, 2, 3, 4, 5], 0, 4)
     * 1
     * > findMin([4, 6, 8], 0, 2)
     * 4
     * > findMin([2, 3, 5, 7, 9], 0, 4)
     * 2
     */
    public static int findMin(List<Integer> arr, int low, int high) {
        if (arr.size() > 0) {
            if (low > high) {
                return findMin(arr.subList(low, high), 0, arr.size() - 1);
            } else {
                return arr.get(0);
            }
        }
        return -1;
    }
}