import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class RotateRight {
    /**
     * * Write a function to rotate a given list by specified number of items to the right direction.
     *
     * > rotateRight([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], 3, 4)
     * [8, 9, 10, 1, 2, 3, 4, 5, 6]
     * > rotateRight([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], 2, 2)
     * [9, 10, 1, 2, 3, 4, 5, 6, 7, 8]
     * > rotateRight([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], 5, 2)
     * [6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8]
     */
    public static List<Integer> rotateRight(List<Integer> list1, int m, int n) {
        if (list1 == null || list1.isEmpty() || m < 0 || n <= 0) return list1;

        int listlen = list1.size();
        List<Integer> result = new ArrayList<Integer>(listlen);

        result.addAll(list1.subList(listlen-m, listlen));
        result.addAll(list1.subList(0, listlen-n));
        return result;
    }
}