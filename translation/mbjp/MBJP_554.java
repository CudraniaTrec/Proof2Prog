import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class Split {
    /**
     * * Write a Java function to find odd numbers from a mixed list.
     *
     * > split([1, 2, 3, 4, 5, 6])
     * [1, 3, 5]
     * > split([10, 11, 12, 13])
     * [11, 13]
     * > split([7, 8, 9, 1])
     * [7, 9, 1]
     */
    public static List<Integer> split(List<Integer> list) {
        if (list.size() < 2) {
            return list;
        }
        List<Integer> list2 = new ArrayList<>();
        int max = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                min = Math.min(min, list.get(i));
                max = Math.max(max, list.get(i));
            }
            if (list.get(i) % 2 == 1) {
                list2.add(list.get(i));
            }
        }
        return list2;
    }
}