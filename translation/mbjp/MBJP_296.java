import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class GetInvCount {
    /**
     * * Write a Java function to count inversions in an array.
     *
     * > getInvCount([1, 20, 6, 4, 5], 5)
     * 5
     * > getInvCount([1, 2, 1], 3)
     * 1
     * > getInvCount([1, 2, 5, 6, 1], 5)
     * 3
     */
    public static int getInvCount(List<Integer> arr, int n) {
        int invCnt = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            int a = arr.get(i);
            for (int j = i + 1; j < n; j++) {
                int b = arr.get(j);
                if (a > b) {
                    count++;
                }
            }
            invCnt += count;
        }
        return invCnt;
    }
}