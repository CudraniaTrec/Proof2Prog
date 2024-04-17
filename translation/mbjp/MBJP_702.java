import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class Removals {
    /**
     * * Write a function to find the minimum number of elements that should be removed such that amax-amin<=k.
     *
     * > removals([1, 3, 4, 9, 10, 11, 12, 17, 20], 9, 4)
     * 5
     * > removals([1, 5, 6, 2, 8], 5, 2)
     * 3
     * > removals([1, 2, 3, 4, 5, 6], 6, 3)
     * 2
     */
    public static int removals(List<Integer> arr, int n, int k) {
        int count = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) > n || i - k > 0) {
                count++;
            }
        }
        return count;
    }
}