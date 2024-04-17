import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FrequencyOfSmallest {
    /**
     * * Write a Java function to find the frequency of the smallest value in a given array.
     *
     * > frequencyOfSmallest(5, [1, 2, 3, 4, 3])
     * 1
     * > frequencyOfSmallest(7, [3, 1, 2, 5, 6, 2, 3])
     * 1
     * > frequencyOfSmallest(7, [3, 3, 6, 3, 7, 4, 9])
     * 3
     */
    public static int frequencyOfSmallest(int n, List<Integer> arr) {
        if (n <= 0) {
            return 0;
        }
        if (arr == null) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (Integer i : arr) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }
}