import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CheckGreater {
    /**
     * * Write a function to check if each element of the second tuple is greater than its corresponding index in the first tuple.
     *
     * > checkGreater([10, 4, 5], [13, 5, 18])
     * true
     * > checkGreater([1, 2, 3], [2, 1, 4])
     * false
     * > checkGreater([4, 5, 6], [5, 6, 7])
     * true
     */
    public static Boolean checkGreater(List<Integer> testTup1, List<Integer> testTup2) {
        boolean result = true;
        int testLen = testTup1.size();
        for (int i = 0; i < testLen; i++) {
            if (testTup1.get(i) > testTup2.get(i)) {
                result = false;
                break;
            }
        }
        return result;
    }
}