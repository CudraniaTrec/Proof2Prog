import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class BitwiseXor {
    /**
     * * Write a function to perform the mathematical bitwise xor operation across the given tuples.
     *
     * > bitwiseXor([10, 4, 6, 9], [5, 2, 3, 3])
     * [15, 6, 5, 10]
     * > bitwiseXor([11, 5, 7, 10], [6, 3, 4, 4])
     * [13, 6, 3, 14]
     * > bitwiseXor([12, 6, 8, 11], [7, 4, 5, 6])
     * [11, 2, 13, 13]
     */
    public static List<Integer> bitwiseXor(List<Integer> testTup1, List<Integer> testTup2) {
        if (testTup1.size() != testTup2.size()) {
            throw new IllegalArgumentException("testTup1 > testTup2 : " + testTup1.size() + " != " + testTup2.size());
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < testTup1.size(); i++) {
            res.add(testTup1.get(i) ^ testTup2.get(i));
        }
        return res;
    }
}