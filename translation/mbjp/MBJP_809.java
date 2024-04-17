import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CheckSmaller {
    /**
     * * Write a function to check if each element of second tuple is smaller than its corresponding index in first tuple.
     *
     * > checkSmaller([1, 2, 3], [2, 3, 4])
     * false
     * > checkSmaller([4, 5, 6], [3, 4, 5])
     * true
     * > checkSmaller([11, 12, 13], [10, 11, 12])
     * true
     */
    public static Boolean checkSmaller(List<Integer> testTup1, List<Integer> testTup2) {
        if (testTup1.size() > testTup2.size()) {
            return false;
        }
        for (int i = 0; i < testTup1.size(); i++) {
            if (testTup1.get(i) < testTup2.get(i)) {
                return false;
            }
        }
        return true;
    }
}