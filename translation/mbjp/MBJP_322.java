import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class PositionMin {
    /**
     * * Write a function to find all index positions of the minimum values in a given list.
     *
     * > positionMin([12, 33, 23, 10, 67, 89, 45, 667, 23, 12, 11, 10, 54])
     * [3, 11]
     * > positionMin([1, 2, 2, 2, 4, 4, 4, 5, 5, 5, 5])
     * [0]
     * > positionMin([2, 1, 5, 6, 8, 3, 4, 9, 10, 11, 8, 12])
     * [1]
     */
    public static List<Integer> positionMin(List<Integer> list1) {
        List<Integer> list = new ArrayList<>();
        if (list1.isEmpty()) {
            return list;
        }
        int min = list1.get(0);
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) < min) {
                min = list1.get(i);
            }
        }
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) == min) {
                list.add(i);
            }
        }
        return list;
    }
}