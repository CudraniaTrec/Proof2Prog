import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class RadixSort {
    /**
     * * Write a function to sort a list of elements using radix sort.
     *
     * > radixSort([15, 79, 25, 68, 37])
     * [15, 25, 37, 68, 79]
     * > radixSort([9, 11, 8, 7, 3, 2])
     * [2, 3, 7, 8, 9, 11]
     * > radixSort([36, 12, 24, 26, 29])
     * [12, 24, 26, 29, 36]
     */
    public static List<Integer> radixSort(List<Integer> nums) {
        int max = -1;
        for (int i : nums) {
            max = Math.max(max, i);
        }

        List<List<Integer>> buckets = new ArrayList<List<Integer>>();
        for (int i = 0; i < 10; i++) {
            buckets.add(new ArrayList<Integer>());
        }

        for (int i : nums) {
            int digit = (max + "").length() - 1;
            buckets.get(digit).add(i);
        }

        for (int i = 0; i < buckets.size(); i++) {
            Collections.sort(buckets.get(i));
        }

        List<Integer> sortedNums = new ArrayList<Integer>();
        for (List<Integer> bucket : buckets) {
            sortedNums.addAll(bucket);
        }

        return sortedNums;
    }
}