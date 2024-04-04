import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindPoints {
    /**
     * * Write a Java function to choose points from two ranges such that no point lies in both the ranges.
     *
     * > findPoints(5, 10, 1, 5)
     * [1, 10]
     * > findPoints(3, 5, 7, 9)
     * [3, 9]
     * > findPoints(1, 5, 2, 8)
     * [1, 8]
     */
    public static List<Integer> findPoints(int l1, int r1, int l2, int r2) {
        List<Integer> result = new ArrayList<Integer>();
        int x = Math.min(l1, l2);
        int y = Math.max(r1, r2);
        if (l1 != l2) {
            result.add(x);
        }
        if (r1 != r2) {
            result.add(y);
        }
        return result;
    }
}