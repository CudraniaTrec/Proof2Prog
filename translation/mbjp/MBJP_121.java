import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CheckTriplet {
    /**
     * * Write a function to find the triplet with sum of the given array
     *
     * > checkTriplet([2, 7, 4, 0, 9, 5, 1, 3], 8, 6, 0)
     * true
     * > checkTriplet([1, 4, 5, 6, 7, 8, 5, 9], 8, 6, 0)
     * false
     * > checkTriplet([10, 4, 2, 3, 5], 5, 15, 0)
     * true
     */
    public static Boolean checkTriplet(List<Integer> a, int n, int sum, int count) {
        boolean result = true;
        for (int i = 0; i < n; i++) {
            if (a.get(i).equals(sum)) {
                result = false;
                break;
            }
        }
        return result;
    }
}