import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindFirstMissing {
    /**
     * * Write a Java function to find the smallest missing number from the given array.
     *
     * > findFirstMissing([0, 1, 2, 3], 0, 3)
     * 4
     * > findFirstMissing([0, 1, 2, 6, 9], 0, 4)
     * 3
     * > findFirstMissing([2, 3, 5, 8, 9], 0, 4)
     * 0
     */
    public static int findFirstMissing(List<Integer> array, int start, int end) {
        if (start > end) {
            return -1;
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (array.get(mid) == mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}