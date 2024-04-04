import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class AddPairwise {
    /**
     * * Write a function to find the pairwise addition of the elements of the given tuples.
     *
     * > addPairwise([1, 5, 7, 8, 10])
     * [6, 12, 15, 18]
     * > addPairwise([2, 6, 8, 9, 11])
     * [8, 14, 17, 20]
     * > addPairwise([3, 7, 9, 10, 12])
     * [10, 16, 19, 22]
     */
    public static List<Integer> addPairwise(List<Integer> testTup) {
        if (testTup == null || testTup.size() == 0) {
            return null;
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < testTup.size(); i++) {
            if (i != 0) {
                result.add(testTup.get(i - 1) + testTup.get(i));
            }
        }
        return result;
    }
}