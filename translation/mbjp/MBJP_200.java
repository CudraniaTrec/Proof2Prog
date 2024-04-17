import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class PositionMax {
    /**
     * * Write a function to find all index positions of the maximum values in a given list.
     *
     * > positionMax([12, 33, 23, 10, 67, 89, 45, 667, 23, 12, 11, 10, 54])
     * [7]
     * > positionMax([1, 2, 2, 2, 4, 4, 4, 5, 5, 5, 5])
     * [7, 8, 9, 10]
     * > positionMax([2, 1, 5, 6, 8, 3, 4, 9, 10, 11, 8, 12])
     * [11]
     */
    public static List<Integer> positionMax(List<Integer> list1) {
        List<Integer> list = new ArrayList<Integer>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) > max) {
                max = list1.get(i);
            }
        }
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) == max) {
                list.add(i);
            }
        }
        return list;
    }
}