import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class KthElement {
    /**
     * * Write a function to find the kth element in the given array.
     *
     * > kthElement([12, 3, 5, 7, 19], 5, 2)
     * 3
     * > kthElement([17, 24, 8, 23], 4, 3)
     * 8
     * > kthElement([16, 21, 25, 36, 4], 5, 4)
     * 36
     */
    public static int kthElement(List<Integer> arr, int n, int k) {
        if (k == 0) {
            return arr.get(n - 1);
        }
        int tmp = arr.get(n - 1);
        for (int i = 0; i < k; i++) {
            tmp = arr.get(i);
        }
        return tmp;
    }
}