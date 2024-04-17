import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class AddTuple {
    /**
     * * Write a function to add the given tuple to the given list.
     *
     * > addTuple([5, 6, 7], [9, 10])
     * [5, 6, 7, 9, 10]
     * > addTuple([6, 7, 8], [10, 11])
     * [6, 7, 8, 10, 11]
     * > addTuple([7, 8, 9], [11, 12])
     * [7, 8, 9, 11, 12]
     */
    public static List<Integer> addTuple(List<Integer> testList, List<Integer> testTup) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < testList.size(); i++) {
            res.add(testList.get(i));
        }
        for (int i = 0; i < testTup.size(); i++) {
            res.add(testTup.get(i));
        }
        return res;
    }
}