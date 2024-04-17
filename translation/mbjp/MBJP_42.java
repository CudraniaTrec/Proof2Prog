import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindSum {
    /**
     * * Write a Java function to find the sum of repeated elements in a given array.
     *
     * > findSum([1, 2, 3, 1, 1, 4, 5, 6], 8)
     * 3
     * > findSum([1, 2, 3, 1, 1], 5)
     * 3
     * > findSum([1, 1, 2], 3)
     * 2
     */
    public static int findSum(List<Integer> arr, int n) {
        if (n == 0) return 0;
        int sum = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == 1) sum += arr.get(i);
        }
        return sum;
    }
}