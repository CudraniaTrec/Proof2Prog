import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SumRangeList {
    /**
     * * Write a function to find sum of the numbers in a list between the indices of a specified range.
     *
     * > sumRangeList([2, 1, 5, 6, 8, 3, 4, 9, 10, 11, 8, 12], 8, 10)
     * 29
     * > sumRangeList([2, 1, 5, 6, 8, 3, 4, 9, 10, 11, 8, 12], 5, 7)
     * 16
     * > sumRangeList([2, 1, 5, 6, 8, 3, 4, 9, 10, 11, 8, 12], 7, 10)
     * 38
     */
    public static int sumRangeList(List<Integer> list1, int m, int n) {
        int sum = 0;
        int size = list1.size();
        for (int i = m; i <= n; i++) {
            sum += list1.get(i);
        }
        return sum;
    }
}