import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class PairOrSum {
    /**
     * * Write a Java function to find the sum of xor of all pairs of numbers in the given array.
     *
     * > pairOrSum([5, 9, 7, 6], 4)
     * 47
     * > pairOrSum([7, 3, 5], 3)
     * 12
     * > pairOrSum([7, 3], 2)
     * 4
     */
    public static int pairOrSum(List<Integer> arr, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                sum += arr.get(i) ^ arr.get(j);
            }
        }
        return sum;
    }
}