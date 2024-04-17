import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindFirstOccurrence {
    /**
     * * Write a function to find the index of the first occurrence of a given number in a sorted array.
     *
     * > findFirstOccurrence([2, 5, 5, 5, 6, 6, 8, 9, 9, 9], 5)
     * 1
     * > findFirstOccurrence([2, 3, 5, 5, 6, 6, 8, 9, 9, 9], 5)
     * 2
     * > findFirstOccurrence([2, 4, 1, 5, 6, 6, 8, 9, 9, 9], 6)
     * 4
     */
    public static int findFirstOccurrence(List<Integer> a, int x) {
        if (a == null) {
            return -1;
        }
        int i = 0;
        while (i < a.size()) {
            if (a.get(i).equals(x)) {
                return i;
            }
            i++;
        }
        return -1;
    }
}