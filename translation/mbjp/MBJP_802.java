import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CountRotation {
    /**
     * * Write a Java function to count the number of rotations required to generate a sorted array.
     *
     * > countRotation([3, 2, 1], 3)
     * 1
     * > countRotation([4, 5, 1, 2, 3], 5)
     * 2
     * > countRotation([7, 8, 9, 1, 2, 3], 6)
     * 3
     */
    public static int countRotation(List<Integer> arr, int n) {
        int count = 0;
        int l = 0, r = n - 1;

        while (l < r) {
            int m = l + (r - l) / 2;
            if (arr.get(m) <= arr.get(r)) {
                r = m;
            } else {
                l = m + 1;
            }
            count += (r - l + 1) / n + 1;
        }
        return count;
    }
}