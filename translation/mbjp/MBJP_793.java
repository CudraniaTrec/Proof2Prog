import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class Last {
    /**
     * * Write a Java function to find the last position of an element in a sorted array.
     *
     * > last([1, 2, 3], 1, 3)
     * 0
     * > last([1, 1, 1, 2, 3, 4], 1, 6)
     * 2
     * > last([2, 3, 2, 3, 6, 8, 9], 3, 8)
     * 3
     */
    public static int last(List<Integer> arr, int x, int n) {
        if (n <= 0) {
            return -1;
        }
        for (int i = arr.size() - 1; i >= 0; i--) {
            if (arr.get(i).equals(x)) {
                return i;
            }
        }
        return -1;
    }
}