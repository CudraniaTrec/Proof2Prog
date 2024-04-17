import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CountX {
    /**
     * * Write a Java function to count the occcurences of an element in a tuple.
     *
     * > countX([10, 8, 5, 2, 10, 15, 10, 8, 5, 8, 8, 2], 4)
     * 0
     * > countX([10, 8, 5, 2, 10, 15, 10, 8, 5, 8, 8, 2], 10)
     * 3
     * > countX([10, 8, 5, 2, 10, 15, 10, 8, 5, 8, 8, 2], 8)
     * 4
     */
    public static int countX(List<Integer> tup, int x) {
        int count = 0;
        for (Integer num : tup) {
            if (num == x) {
                count++;
            }
        }
        return count;
    }
}