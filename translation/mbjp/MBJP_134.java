import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CheckLast {
    /**
     * * Write a Java function to check whether the last element of given array is even or odd after performing an operation p times.
     *
     * > checkLast([5, 7, 10], 3, 1)
     * "ODD"
     * > checkLast([2, 3], 2, 3)
     * "EVEN"
     * > checkLast([1, 2, 3], 3, 1)
     * "ODD"
     */
    public static String checkLast(List<Integer> arr, int n, int p) {
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = arr.get(i) % p;
        }
        int o = 0;
        for (int i = 0; i < n; i++) {
            if (c[i] % p != 0) {
                o += c[i] % p;
                if (o > n) {
                    return "ODD";
                } else {
                    return "EVEN";
                }
            }
        }
        return "ODD";
    }
}