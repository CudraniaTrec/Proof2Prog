import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FrequencyLists {
    /**
     * * Write a function to find frequency count of list of lists.
     *
     * > frequencyLists([[1, 2, 3, 2], [4, 5, 6, 2], [7, 8, 9, 5]])
     * {1: 1, 2: 3, 3: 1, 4: 1, 5: 2, 6: 1, 7: 1, 8: 1, 9: 1}
     * > frequencyLists([[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12]])
     * {1: 1, 2: 1, 3: 1, 4: 1, 5: 1, 6: 1, 7: 1, 8: 1, 9: 1, 10: 1, 11: 1, 12: 1}
     * > frequencyLists([[20, 30, 40, 17], [18, 16, 14, 13], [10, 20, 30, 40]])
     * {20: 2, 30: 2, 40: 2, 17: 1, 18: 1, 16: 1, 14: 1, 13: 1, 10: 1}
     */
    public static HashMap<Integer, Integer> frequencyLists(List<List<Integer>> list1) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (List<Integer> list2 : list1) {
            for (int i = 0; i < list2.size(); i++) {
                if (!freq.containsKey(list2.get(i))) {
                    freq.put(list2.get(i), 0);
                }
                freq.put(list2.get(i), freq.get(list2.get(i)) + 1);
            }
        }
        return freq;
    }
}