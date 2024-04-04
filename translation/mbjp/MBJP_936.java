import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ReArrangeTuples {
    /**
     * * Write a function to re-arrange the given tuples based on the given ordered list.
     *
     * > reArrangeTuples([[4, 3], [1, 9], [2, 10], [3, 2]], [1, 4, 2, 3])
     * [[1, 9], [4, 3], [2, 10], [3, 2]]
     * > reArrangeTuples([[5, 4], [2, 10], [3, 11], [4, 3]], [3, 4, 2, 3])
     * [[3, 11], [4, 3], [2, 10], [3, 11]]
     * > reArrangeTuples([[6, 3], [3, 8], [5, 7], [2, 4]], [2, 5, 3, 6])
     * [[2, 4], [5, 7], [3, 8], [6, 3]]
     */
    public static List<List<Integer>> reArrangeTuples(List<List<Integer>> testList, List<Integer> ordList) {
        // Write your code here
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < ordList.size(); i++) {
            for (int j = 0; j < testList.size(); j++) {
                if (ordList.get(i) == testList.get(j).get(0)) {
                    list.add(testList.get(j));
                }
            }
        }
        return list;
    }
}