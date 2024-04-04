import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ModularSum {
    /**
     * * Write a function to check if there is a subset with sum divisible by m.
     *
     * > modularSum([3, 1, 7, 5], 4, 6)
     * true
     * > modularSum([1, 7], 2, 5)
     * false
     * > modularSum([1, 6], 2, 5)
     * false
     */
    public static Boolean modularSum(List<Integer> arr, int n, int m) {
        int n1 = arr.size();
        int m1 = m - n;
        if (m1 == 0) {
            return true;
        }
        int i = 0;
        while (i < n1 && i < m1) {
            int r = arr.get(i) % m1;
            int c = arr.get(i) / m1;
            if (r == c) {
                return true;
            } else {
                i++;
            }
        }
        return false;
    }
}