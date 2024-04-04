import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MaxLenSub {
    /**
     * * Write a function to find the maximum length of the subsequence with difference between adjacent elements for the given array.
     *
     * > maxLenSub([2, 5, 6, 3, 7, 6, 5, 8], 8)
     * 5
     * > maxLenSub([-2, -1, 5, -1, 4, 0, 3], 7)
     * 4
     * > maxLenSub([9, 11, 13, 15, 18], 5)
     * 1
     */
    public static int maxLenSub(List<Integer> arr, int n) {
        int[] mls = new int[n];
        int max = 0;
        
        // mls[i] => max difference between arr[i] and arr[i-1]
        
        for (int i = 0; i < n; i++) {
            mls[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (Math.abs(arr.get(i) - arr.get(j)) <= 1 && mls[i] < mls[j] + 1) {
                    mls[i] = mls[j] + 1;
                }
            }
            if (max < mls[i]) {
                max = mls[i];
            }
        }
        
        return max;
    }
}