import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MaxOccurrences {
    /**
     * * Write a function to find the item with maximum frequency in a given list.
     *
     * > maxOccurrences([2, 3, 8, 4, 7, 9, 8, 2, 6, 5, 1, 6, 1, 2, 3, 2, 4, 6, 9, 1, 2])
     * [2, 5]
     * > maxOccurrences([2, 3, 8, 4, 7, 9, 8, 7, 9, 15, 14, 10, 12, 13, 16, 16, 18])
     * [8, 2]
     * > maxOccurrences([10, 20, 20, 30, 40, 90, 80, 50, 30, 20, 50, 10])
     * [20, 3]
     */
    public static List<Integer> maxOccurrences(List<Integer> nums) {
        int max = 0, max_occ = 0;
        HashMap<Integer, Integer> occ = new HashMap<>();
        for (int i : nums) {
            if (occ.containsKey(i)) {
                occ.put(i, occ.get(i) + 1);
            } else {
                occ.put(i, 1);
            }
            if (occ.get(i) > max_occ) {
                max_occ = occ.get(i);
                max = i;
            }
        }
        List<Integer> result = new ArrayList<>();
        result.add(max);
        result.add(max_occ);
        return result;
    }
}