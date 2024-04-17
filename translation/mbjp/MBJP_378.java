import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MoveFirst {
    /**
     * * Write a Java function to shift last element to first position in the given list.
     *
     * > moveFirst([1, 2, 3, 4])
     * [4, 1, 2, 3]
     * > moveFirst([0, 1, 2, 3])
     * [3, 0, 1, 2]
     * > moveFirst([9, 8, 7, 1])
     * [1, 9, 8, 7]
     */
    public static List<Integer> moveFirst(List<Integer> testList) {
        List<Integer> list = new ArrayList<>();
        list.add(testList.get(testList.size() - 1));
        list.addAll(testList.subList(0, testList.size() - 1));
        return list;
    }
}