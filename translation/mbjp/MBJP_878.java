import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CheckTuples {
    /**
     * * Write a function to check if the given tuple contains only k elements.
     *
     * > checkTuples([3, 5, 6, 5, 3, 6], [3, 6, 5])
     * true
     * > checkTuples([4, 5, 6, 4, 6, 5], [4, 5, 6])
     * true
     * > checkTuples([9, 8, 7, 6, 8, 9], [9, 8, 1])
     * false
     */
    public static Boolean checkTuples(List<Integer> testTuple, List<Integer> k) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i : k) {
            set.add(i);
        }
        for (int i : testTuple) {
            if (!set.contains(i)) {
                return false;
            }
        }
        return true;
    }
}