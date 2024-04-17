import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SmallestMissing {
    /**
     * * Write a function to find the smallest missing element in a sorted array.
     *
     * > smallestMissing([0, 1, 2, 3, 4, 5, 6], 0, 6)
     * 7
     * > smallestMissing([0, 1, 2, 6, 9, 11, 15], 0, 6)
     * 3
     * > smallestMissing([1, 2, 3, 4, 6, 9, 11, 15], 0, 7)
     * 0
     */
    public static int smallestMissing(List<Integer> a, int leftElement, int rightElement) {
        int missing = 0;
        for (int i = leftElement; i <= rightElement; i++) {
            if (a.get(i) == i) {
                missing++;
            }
        }
        return missing;
    }
}