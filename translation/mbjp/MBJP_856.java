import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindMinSwaps {
    /**
     * * Write a Java function to find minimum adjacent swaps required to sort binary array.
     *
     * > findMinSwaps([1, 0, 1, 0], 4)
     * 3
     * > findMinSwaps([0, 1, 0], 3)
     * 1
     * > findMinSwaps([0, 0, 1, 1, 0], 5)
     * 2
     */
    public static int findMinSwaps(List<Integer> arr, int n) {
        int l = 0;
        int r = n - 1;
        int minSwaps = 0;
        while (l < r) {
            int curr = arr.get(l) + arr.get(r);
            minSwaps += curr - Math.min(arr.get(l), arr.get(r));
            if (arr.get(l) > arr.get(r)) {
                r--;
            } else {
                l++;
            }
        }
        return minSwaps;
    }
}