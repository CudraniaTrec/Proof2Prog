import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SubstractElements {
    /**
     * * Write a function to substract the contents of one tuple with corresponding index of other tuple.
     *
     * > substractElements([10, 4, 5], [2, 5, 18])
     * [8, -1, -13]
     * > substractElements([11, 2, 3], [24, 45, 16])
     * [-13, -43, -13]
     * > substractElements([7, 18, 9], [10, 11, 12])
     * [-3, 7, -3]
     */
    public static List<Integer> substractElements(List<Integer> testTup1, List<Integer> testTup2) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < testTup1.size(); i++) {
            res.add(testTup1.get(i) - testTup2.get(i));
        }
        return res;
    }
}