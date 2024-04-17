import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class RemoveTuple {
    /**
     * * Write a function to remove the duplicates from the given tuple.
     *
     * > removeTuple([1, 3, 5, 2, 3, 5, 1, 1, 3])
     * [1, 2, 3, 5]
     * > removeTuple([2, 3, 4, 4, 5, 6, 6, 7, 8, 8])
     * [2, 3, 4, 5, 6, 7, 8]
     * > removeTuple([11, 12, 13, 11, 11, 12, 14, 13])
     * [11, 12, 13, 14]
     */
    public static List<Integer> removeTuple(List<Integer> testTup) {
        Set<Integer> set = new HashSet<Integer>();
        for (Integer i : testTup) {
            if (!set.contains(i)) {
                set.add(i);
            }
        }
        List<Integer> answer = new ArrayList<Integer>();
        for (Integer integer : set) {
            answer.add(integer);
        }
        Collections.sort(answer);
        return answer;
    }
}