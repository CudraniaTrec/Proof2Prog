import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SumRangeList {
    /**
     * * Write a Java function to calculate the sum of the numbers in a list between the indices of a specified range.
     *
     * > sumRangeList([2, 1, 5, 6, 8, 3, 4, 9, 10, 11, 8, 12], 8, 10)
     * 29
     * > sumRangeList([1, 2, 3, 4, 5], 1, 2)
     * 5
     * > sumRangeList([1, 0, 1, 2, 5, 6], 4, 5)
     * 11
     */
    public static int sumRangeList(List<Integer> nums, int m, int n) {
        int sum = 0;
        for (int i = m; i <= n; i++) {
            sum += nums.get(i);
        }
        return sum;
    }
}