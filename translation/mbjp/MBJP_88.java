import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FreqCount {
    /**
     * * Write a function to get the frequency of the elements in a list.
     *
     * > freqCount([10, 10, 10, 10, 20, 20, 20, 20, 40, 40, 50, 50, 30])
     * {10: 4, 20: 4, 40: 2, 50: 2, 30: 1}
     * > freqCount([1, 2, 3, 4, 3, 2, 4, 1, 3, 1, 4])
     * {1: 3, 2: 2, 3: 3, 4: 3}
     * > freqCount([5, 6, 7, 4, 9, 10, 4, 5, 6, 7, 9, 5])
     * {10: 1, 5: 3, 6: 2, 7: 2, 4: 2, 9: 2}
     */
    public static HashMap<Integer, Integer> freqCount(List<Integer> list1) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < list1.size(); i++) {
            freq.put(list1.get(i), freq.getOrDefault(list1.get(i), 0) + 1);
        }
        return freq;
    }
}