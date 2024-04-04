import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CountTuplex {
    /**
     * * Write a function to count repeated items of a tuple.
     *
     * > countTuplex([2, 4, 5, 6, 2, 3, 4, 4, 7], 4)
     * 3
     * > countTuplex([2, 4, 5, 6, 2, 3, 4, 4, 7], 2)
     * 2
     * > countTuplex([2, 4, 7, 7, 7, 3, 4, 4, 7], 7)
     * 4
     */
    public static int countTuplex(List<Integer> tuplex, int value) {
        int count = 0;
        for (Integer i : tuplex) {
            if (value == i) {
                count++;
            }
        }
        return count;
    }
}