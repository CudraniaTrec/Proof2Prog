import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MultiplyElements {
    /**
     * * Write a function to multiply the adjacent elements of the given tuple.
     *
     * > multiplyElements([1, 5, 7, 8, 10])
     * [5, 35, 56, 80]
     * > multiplyElements([2, 4, 5, 6, 7])
     * [8, 20, 30, 42]
     * > multiplyElements([12, 13, 14, 9, 15])
     * [156, 182, 126, 135]
     */
    public static List<Integer> multiplyElements(List<Integer> testTup) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < testTup.size() - 1; i++) {
            list.add(testTup.get(i) * testTup.get(i + 1));
        }
        return list;
    }
}