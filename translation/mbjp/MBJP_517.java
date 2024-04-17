import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class LargestPos {
    /**
     * * Write a Java function to find the largest postive number from the given list.
     *
     * > largestPos([1, 2, 3, 4, -1])
     * 4
     * > largestPos([0, 1, 2, -5, -1, 6])
     * 6
     * > largestPos([0, 0, 1, 0])
     * 1
     */
    public static int largestPos(List<Integer> list1) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) > max) {
                max = list1.get(i);
            } else if (list1.get(i) < min) {
                min = list1.get(i);
            }
        }
        return max;
    }
}