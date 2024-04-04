import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindSum {
    /**
     * * Write a Java function to find the sum of non-repeated elements in a given array.
     *
     * > findSum([1, 2, 3, 1, 1, 4, 5, 6], 8)
     * 21
     * > findSum([1, 10, 9, 4, 2, 10, 10, 45, 4], 9)
     * 71
     * > findSum([12, 10, 9, 45, 2, 10, 10, 45, 10], 9)
     * 78
     */
    public static int findSum(List<Integer> arr, int n) {
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.size(); i++) {
            if (!set.contains(arr.get(i))) {
                sum += arr.get(i);
                set.add(arr.get(i));
            }
        }
        return sum;
    }
}