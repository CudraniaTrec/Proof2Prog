import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindLastOccurrence {
    /**
     * * Write a function to find the index of the last occurrence of a given number in a sorted array.
     *
     * > findLastOccurrence([2, 5, 5, 5, 6, 6, 8, 9, 9, 9], 5)
     * 3
     * > findLastOccurrence([2, 3, 5, 8, 6, 6, 8, 9, 9, 9], 9)
     * 9
     * > findLastOccurrence([2, 2, 1, 5, 6, 6, 6, 9, 9, 9], 6)
     * 6
     */
    public static int findLastOccurrence(List<Integer> a, int x) {
        for (int i = a.size() - 1; i >= 0; i--) {
            if (a.get(i).equals(x)) {
                return i;
            }
        }
        return -1;
    }
}