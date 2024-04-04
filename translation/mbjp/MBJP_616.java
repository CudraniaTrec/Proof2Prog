import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class TupleModulo {
    /**
     * * Write a function to perfom the modulo of tuple elements in the given two tuples.
     *
     * > tupleModulo([10, 4, 5, 6], [5, 6, 7, 5])
     * [0, 4, 5, 1]
     * > tupleModulo([11, 5, 6, 7], [6, 7, 8, 6])
     * [5, 5, 6, 1]
     * > tupleModulo([12, 6, 7, 8], [7, 8, 9, 7])
     * [5, 6, 7, 1]
     */
    public static List<Integer> tupleModulo(List<Integer> testTup1, List<Integer> testTup2) {
        List<Integer> result = new ArrayList<>();
        int temp1 = 0;
        int temp2 = 0;
        while (temp1 < testTup1.size() && temp2 < testTup2.size()) {
            result.add(testTup1.get(temp1) % testTup2.get(temp2));
            temp1++;
            temp2++;
        }
        return result;
    }
}