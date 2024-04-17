import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CheckSubset {
    /**
     * * Write a function to check if one tuple is a subset of another tuple.
     *
     * > checkSubset([10, 4, 5, 6], [5, 10])
     * true
     * > checkSubset([1, 2, 3, 4], [5, 6])
     * false
     * > checkSubset([7, 8, 9, 10], [10, 8])
     * true
     */
    public static Boolean checkSubset(List<Integer> testTup1, List<Integer> testTup2) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < testTup1.size(); i++) {
            if (set.contains(testTup1.get(i))) {
                return true;
            }
            set.add(testTup1.get(i));
        }
        for (int i = 0; i < testTup2.size(); i++) {
            if (set.contains(testTup2.get(i))) {
                return true;
            }
            set.add(testTup2.get(i));
        }
        return false;
    }
}