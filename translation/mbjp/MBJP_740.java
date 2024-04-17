import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class TupleToDict {
    /**
     * * Write a function to convert the given tuple to a key-value dictionary using adjacent elements.
     *
     * > tupleToDict([1, 5, 7, 10, 13, 5])
     * {1: 5, 7: 10, 13: 5}
     * > tupleToDict([1, 2, 3, 4, 5, 6])
     * {1: 2, 3: 4, 5: 6}
     * > tupleToDict([7, 8, 9, 10, 11, 12])
     * {7: 8, 9: 10, 11: 12}
     */
    public static HashMap<Integer, Integer> tupleToDict(List<Integer> testTup) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < testTup.size(); i += 2) {
            map.put(testTup.get(i), testTup.get(i + 1));
        }
        return map;
    }
}