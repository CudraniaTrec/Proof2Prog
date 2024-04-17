import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ClearTuple {
    /**
     * * Write a function to clear the values of the given tuples.
     *
     * > clearTuple([1, 5, 3, 6, 8])
     * []
     * > clearTuple([2, 1, 4, 5, 6])
     * []
     * > clearTuple([3, 2, 5, 6, 8])
     * []
     */
    public static List<Object> clearTuple(List<Integer> testTup) {
        List<Object> result = new ArrayList<>();
        int total = 0;
        int size = testTup.size();
        for (int i = 0; i < size; i++) {
            total += testTup.get(i);
        }
        List<Object> l = new ArrayList<>(total);
        while (l.size() > 0) {
            result.add(l.get(0));
            l = new ArrayList<>(total);
        }
        return result;
    }
}