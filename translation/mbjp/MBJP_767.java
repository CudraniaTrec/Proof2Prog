import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class GetPairsCount {
    /**
     * * Write a Java function to count the number of pairs whose sum is equal to ‘sum’.
     *
     * > getPairsCount([1, 1, 1, 1], 4, 2)
     * 6
     * > getPairsCount([1, 5, 7, -1, 5], 5, 6)
     * 3
     * > getPairsCount([1, -2, 3], 3, 1)
     * 1
     */
    public static int getPairsCount(List<Integer> arr, int n, int sum) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr.get(j) + arr.get(i) == sum) {
                    count++;
                }
            }
        }
        return count;
    }
}