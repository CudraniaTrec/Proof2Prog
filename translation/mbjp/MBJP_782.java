import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class OddLengthSum {
    /**
     * * Write a Java function to find the sum of all odd length subarrays.
     *
     * > oddLengthSum([1, 2, 4])
     * 14
     * > oddLengthSum([1, 2, 1, 2])
     * 15
     * > oddLengthSum([1, 7])
     * 8
     */
    public static int oddLengthSum(List<Integer> arr) {
        int sum = 0, l = arr.size();
        for (int i = 0; i < l; i++) {
            sum += Math.floor(((i + 1) * (l - i) + 1) / 2) * arr.get(i);
        }
        return sum;
    }
}