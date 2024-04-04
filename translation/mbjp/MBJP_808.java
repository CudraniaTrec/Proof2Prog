import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CheckK {
    /**
     * * Write a function to check if the given tuples contain the k or not.
     *
     * > checkK([10, 4, 5, 6, 8], 6)
     * true
     * > checkK([1, 2, 3, 4, 5, 6], 7)
     * false
     * > checkK([7, 8, 9, 44, 11, 12], 11)
     * true
     */
    public static Boolean checkK(List<Integer> testTup, int k) {
        if (testTup == null || testTup.isEmpty()) {
            return false;
        }
        for (int i = 0; i < testTup.size(); i++) {
            if (k == testTup.get(i).intValue()) {
                return true;
            }
        }
        return false;
    }
}