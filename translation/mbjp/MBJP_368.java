import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class RepeatTuples {
    /**
     * * Write a function to repeat the given tuple n times.
     *
     * > repeatTuples([1, 3], 4)
     * [[1, 3], [1, 3], [1, 3], [1, 3]]
     * > repeatTuples([1, 2], 3)
     * [[1, 2], [1, 2], [1, 2]]
     * > repeatTuples([3, 4], 5)
     * [[3, 4], [3, 4], [3, 4], [3, 4], [3, 4]]
     */
    public static List<List<Integer>> repeatTuples(List<Integer> testTup, int n) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < testTup.size(); j++) {
                list.add(testTup.get(j));
            }
            result.add(list);
        }
        return result;
    }
}