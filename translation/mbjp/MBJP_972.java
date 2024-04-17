import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ConcatenateNested {
    /**
     * * Write a function to concatenate the given two tuples to a nested tuple.
     *
     * > concatenateNested([3, 4], [5, 6])
     * [3, 4, 5, 6]
     * > concatenateNested([1, 2], [3, 4])
     * [1, 2, 3, 4]
     * > concatenateNested([4, 5], [6, 8])
     * [4, 5, 6, 8]
     */
    public static List<Integer> concatenateNested(List<Integer> testTup1, List<Integer> testTup2) {
        List<Integer> output = new ArrayList<>();
        for (Integer i : testTup1) {
            output.add(i);
        }
        for (Integer i : testTup2) {
            output.add(i);
        }
        return output;
    }
}