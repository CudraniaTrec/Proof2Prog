import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class First {
    /**
     * * Write a Java function to find the first position of an element in a sorted array.
     *
     * > first([1, 2, 3, 4, 5, 6, 6], 6, 6)
     * 5
     * > first([1, 2, 2, 2, 3, 2, 2, 4, 2], 2, 9)
     * 1
     * > first([1, 2, 3], 1, 3)
     * 0
     */
    public static int first(List<Integer> arr, int x, int n) {
        int prev = arr.get(0);
        int curr = arr.get(0);
        for (int i = 0; i < n; i++) {
            if (curr == x) {
                return i;
            }
            if (curr < x) {
                curr++;
            } else {
                prev = curr;
            }
        }
        return -1;
    }
}