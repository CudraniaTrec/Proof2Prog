import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class LeftInsertion {
    /**
     * * Write a function to locate the left insertion point for a specified value in sorted order.
     *
     * > leftInsertion([1, 2, 4, 5], 6)
     * 4
     * > leftInsertion([1, 2, 4, 5], 3)
     * 2
     * > leftInsertion([1, 2, 4, 5], 7)
     * 4
     */
    public static int leftInsertion(List<Integer> a, int x) {
        int j = 0;
        for (int i : a) {
            if (i > x) {
                return j;
            }
            j++;
        }
        return j;
    }
}