import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ExtractSymmetric {
    /**
     * * Write a function to extract all the pairs which are symmetric in the given tuple list.
     *
     * > extractSymmetric([[6, 7], [2, 3], [7, 6], [9, 8], [10, 2], [8, 9]])
     * {[6, 7], [8, 9]}
     * > extractSymmetric([[7, 8], [3, 4], [8, 7], [10, 9], [11, 3], [9, 10]])
     * {[9, 10], [7, 8]}
     * > extractSymmetric([[8, 9], [4, 5], [9, 8], [11, 10], [12, 4], [10, 11]])
     * {[8, 9], [10, 11]}
     */
    public static HashSet<List<Integer>> extractSymmetric(List<List<Integer>> testList) {
        HashSet<List<Integer>> symmetricPairs = new HashSet<List<Integer>>();
        HashSet<List<Integer>> seenPairs = new HashSet<List<Integer>>();
        for (List<Integer> pair: testList) {
            int smaller = pair.get(0) < pair.get(1) ? pair.get(0) : pair.get(1);
            int greater = pair.get(0) < pair.get(1) ? pair.get(1) : pair.get(0);
            if (!seenPairs.add(Arrays.asList(smaller, greater))) {
                symmetricPairs.add(Arrays.asList(smaller, greater));
            }
        }

        return symmetricPairs;
    }
}