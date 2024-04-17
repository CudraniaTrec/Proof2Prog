import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FindExponentio {
    /**
     * * Write a function to perform the exponentiation of the given two tuples.
     *
     * > findExponentio([10, 4, 5, 6], [5, 6, 7, 5])
     * [100000, 4096, 78125, 7776]
     * > findExponentio([11, 5, 6, 7], [6, 7, 8, 6])
     * [1771561, 78125, 1679616, 117649]
     * > findExponentio([12, 6, 7, 8], [7, 8, 9, 7])
     * [35831808, 1679616, 40353607, 2097152]
     */
    public static List<Integer> findExponentio(List<Integer> testTup1, List<Integer> testTup2) {
        if (testTup1.size() != testTup2.size()) {
            return new ArrayList<>();
        }

        int l = testTup1.size();
        int m = testTup2.size();

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < l; i++) {
            result.add((int) Math.pow(testTup1.get(i), testTup2.get(i)));
        }

        return result;
    }
}