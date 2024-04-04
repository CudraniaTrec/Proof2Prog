import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CountElementFreq {
    /**
     * * Write a function to count the element frequency in the mixed nested tuple.
     *
     * > countElementFreq([5, 6, [5, 6], 7, [8, 9], 9])
     * {5: 2, 6: 2, 7: 1, 8: 1, 9: 2}
     * > countElementFreq([6, 7, [6, 7], 8, [9, 10], 10])
     * {6: 2, 7: 2, 8: 1, 9: 1, 10: 2}
     * > countElementFreq([7, 8, [7, 8], 9, [10, 11], 11])
     * {7: 2, 8: 2, 9: 1, 10: 1, 11: 2}
     */
    public static HashMap<Integer, Integer> countElementFreq(List<Object> testTuple) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (Object object: testTuple) {
            if (object instanceof Integer) {
                Integer num1 = (Integer)object;
                if (freq.containsKey(num1)) {
                    freq.put(num1, freq.get(num1) + 1);
                } else {
                    freq.put(num1, 1);
                }
            } else if (object instanceof List) {
                List<Integer> list1 = (List<Integer>)object;
                for (int i : list1) {
                    freq.put(i, freq.getOrDefault(i, 0) + 1);
                }
            } else {
                throw new RuntimeException("Bad object");
            }
        }
        return freq;
    }
}