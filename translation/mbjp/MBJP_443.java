import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class LargestNeg {
    /**
     * * Write a Java function to find the largest negative number from the given list.
     *
     * > largestNeg([1, 2, 3, -4, -6])
     * -6
     * > largestNeg([1, 2, 3, -8, -9])
     * -9
     * > largestNeg([1, 2, 3, 4, -1])
     * -1
     */
    public static int largestNeg(List<Integer> list1) {
        int l = 0;
        int r = 0;
        for (int i = 0; i < list1.size(); i++) {
            if (l < list1.get(i)) l = list1.get(i);
            if (r > list1.get(i)) r = list1.get(i);
        }
        return r;
    }
}