import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SimilarElements {
    /**
     * * Write a function to find the similar elements from the given two tuple lists.
     *
     * > similarElements([3, 4, 5, 6], [5, 7, 4, 10])
     * [4, 5]
     * > similarElements([1, 2, 3, 4], [5, 4, 3, 7])
     * [3, 4]
     * > similarElements([11, 12, 14, 13], [17, 15, 14, 13])
     * [13, 14]
     */
    public static List<Integer> similarElements(List<Integer> testTup1, List<Integer> testTup2) {
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        for (int i : testTup1) {
            set1.add(i);
        }
        for (int i : testTup2) {
            set2.add(i);
        }
        set1.retainAll(set2);
        return new ArrayList<Integer>(set1);
    }
}