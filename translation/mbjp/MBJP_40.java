import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FreqElement {
    /**
     * * Write a function to find frequency of the elements in a given list of lists using collections module.
     *
     * > freqElement([[1, 2, 3, 2], [4, 5, 6, 2], [7, 1, 9, 5]])
     * {2: 3, 1: 2, 5: 2, 3: 1, 4: 1, 6: 1, 7: 1, 9: 1}
     * > freqElement([[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12]])
     * {1: 1, 2: 1, 3: 1, 4: 1, 5: 1, 6: 1, 7: 1, 8: 1, 9: 1, 10: 1, 11: 1, 12: 1}
     * > freqElement([[15, 20, 30, 40], [80, 90, 100, 110], [30, 30, 80, 90]])
     * {30: 3, 80: 2, 90: 2, 15: 1, 20: 1, 40: 1, 100: 1, 110: 1}
     */
    public static HashMap<Integer, Integer> freqElement(List<List<Integer>> nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (List<Integer> list : nums) {
            for (int i : list) {
                freq.put(i, freq.getOrDefault(i, 0) + 1);
            }
        }
        return freq;
    }
}