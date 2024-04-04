import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SubstractElements {
    /**
     * * Write a function to substract the elements of the given nested tuples.
     *
     * > substractElements([[1, 3], [4, 5], [2, 9], [1, 10]], [[6, 7], [3, 9], [1, 1], [7, 3]])
     * [[-5, -4], [1, -4], [1, 8], [-6, 7]]
     * > substractElements([[13, 4], [14, 6], [13, 10], [12, 11]], [[19, 8], [14, 10], [12, 2], [18, 4]])
     * [[-6, -4], [0, -4], [1, 8], [-6, 7]]
     * > substractElements([[19, 5], [18, 7], [19, 11], [17, 12]], [[12, 9], [17, 11], [13, 3], [19, 5]])
     * [[7, -4], [1, -4], [6, 8], [-2, 7]]
     */
    public static List<List<Integer>> substractElements(List<List<Integer>> testTup1, List<List<Integer>> testTup2) {
        List<List<Integer>> output = new ArrayList<>();

        for (int i = 0; i < testTup1.size(); i++) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j < testTup2.get(i).size(); j++) {
                cur.add(testTup1.get(i).get(j) - testTup2.get(i).get(j));
            }
            output.add(cur);
        }

        return output;
    }
}