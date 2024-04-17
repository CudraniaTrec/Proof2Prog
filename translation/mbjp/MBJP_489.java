import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FrequencyOfLargest {
    /**
     * * Write a Java function to find the frequency of the largest value in a given array.
     *
     * > frequencyOfLargest(5, [1, 2, 3, 4, 4])
     * 2
     * > frequencyOfLargest(3, [5, 6, 5])
     * 1
     * > frequencyOfLargest(4, [2, 7, 7, 7])
     * 3
     */
    public static int frequencyOfLargest(int n, List<Integer> arr) {
        int max = arr.get(0);
        int freq = 1;
        for (int i = 1; i < n; i++) {
            if (arr.get(i) > max) {
                max = arr.get(i);
                freq = 1;
            } else if (arr.get(i) == max) {
                freq++;
            }
        }
        return freq;
    }
}