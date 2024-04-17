import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class NegCount {
    /**
     * * Write a Java function to count negative numbers in a list.
     *
     * > negCount([-1, -2, 3, -4, -5])
     * 4
     * > negCount([1, 2, 3])
     * 0
     * > negCount([1, 2, -3, -10, 20])
     * 2
     */
    public static int negCount(List<Integer> list) {
        int n = 0;
        for (Integer i : list) {
            if (i < 0) {
                n++;
            }
        }
        return n;
    }
}