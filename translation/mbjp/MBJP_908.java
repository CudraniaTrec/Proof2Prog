import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindFixedPoint {
    /**
     * * Write a function to find the fixed point in the given array.
     *
     * > findFixedPoint([-10, -1, 0, 3, 10, 11, 30, 50, 100], 9)
     * 3
     * > findFixedPoint([1, 2, 3, 4, 5, 6, 7, 8], 8)
     * -1
     * > findFixedPoint([0, 2, 5, 8, 17], 5)
     * 0
     */
    public static int findFixedPoint(List<Integer> arr, int n) {
        int start, end;
        for (int i = 0; i < arr.size(); i++) {
            start = n + i * 10;
            end = n + i * -1;
            if (arr.get(i).equals(i)) {
                return i;
            }
        }
        return -1;
    }
}