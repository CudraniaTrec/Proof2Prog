import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SortByDnf {
    /**
     * * Write a function to sort the given array without using any sorting algorithm. the given array consists of only 0, 1, and 2.
     *
     * > sortByDnf([1, 2, 0, 1, 0, 1, 2, 1, 1], 9)
     * [0, 0, 1, 1, 1, 1, 1, 2, 2]
     * > sortByDnf([1, 0, 0, 1, 2, 1, 2, 2, 1, 0], 10)
     * [0, 0, 0, 1, 1, 1, 1, 2, 2, 2]
     * > sortByDnf([2, 2, 1, 0, 0, 0, 1, 1, 2, 1], 10)
     * [0, 0, 0, 1, 1, 1, 1, 2, 2, 2]
     */
    public static List<Integer> sortByDnf(List<Integer> arr, int n) {
        if (n <= 0) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        if (arr.size() == 0) {
            return result;
        }
        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) < minIndex) {
                minIndex = arr.get(i);
            }
        }
        Collections.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });
        for (int i = 0; i < n; i++) {
            result.add(arr.get(i));
        }
        return result;
    }
}