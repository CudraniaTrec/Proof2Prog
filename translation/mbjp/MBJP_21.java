import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MultiplesOfNum {
    /**
     * * Write a function to find m number of multiples of n.
     *
     * > multiplesOfNum(4, 3)
     * [3, 6, 9, 12]
     * > multiplesOfNum(2, 5)
     * [5, 10]
     * > multiplesOfNum(9, 2)
     * [2, 4, 6, 8, 10, 12, 14, 16, 18]
     */
    public static List<Integer> multiplesOfNum(int m, int n) {
        List<Integer> r = new ArrayList<Integer>();
        for (int i = 0; i < m; i++) {
            r.add(n * (i + 1));
        }
        return r;
    }
}