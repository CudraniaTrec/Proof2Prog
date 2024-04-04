import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MaxOccurrences {
    /**
     * * Write a function to find the item with maximum occurrences in a given list.
     *
     * > maxOccurrences([2, 3, 8, 4, 7, 9, 8, 2, 6, 5, 1, 6, 1, 2, 3, 4, 6, 9, 1, 2])
     * 2
     * > maxOccurrences([1, 3, 5, 7, 1, 3, 13, 15, 17, 5, 7, 9, 1, 11])
     * 1
     * > maxOccurrences([1, 2, 3, 2, 4, 5, 1, 1, 1])
     * 1
     */
    public static int maxOccurrences(List<Integer> list1) {
        Set<Integer> set1 = new HashSet<>();
        for (Integer i : list1) {
            set1.add(i);
        }
        int max = 0;
        for (Integer i : set1) {
            max = Math.max(max, list1.get(0));
        }
        return max;
    }
}