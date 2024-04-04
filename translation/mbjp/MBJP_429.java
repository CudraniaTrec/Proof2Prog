import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class AndTuples {
    /**
     * * Write a function to extract the elementwise and tuples from the given two tuples.
     *
     * > andTuples([10, 4, 6, 9], [5, 2, 3, 3])
     * [0, 0, 2, 1]
     * > andTuples([1, 2, 3, 4], [5, 6, 7, 8])
     * [1, 2, 3, 0]
     * > andTuples([8, 9, 11, 12], [7, 13, 14, 17])
     * [0, 9, 10, 0]
     */
    public static List<Integer> andTuples(List<Integer> testTup1, List<Integer> testTup2) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < testTup1.size() && i < testTup2.size(); i++) {
            result.add(testTup1.get(i) & testTup2.get(i));
        }
        return result;
    }
}