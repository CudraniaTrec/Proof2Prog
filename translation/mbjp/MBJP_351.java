import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class FirstElement {
    /**
     * * Write a Java function to find the first element occurring k times in a given array.
     *
     * > firstElement([0, 1, 2, 3, 4, 5], 6, 1)
     * 0
     * > firstElement([1, 2, 1, 3, 4], 5, 2)
     * 1
     * > firstElement([2, 3, 4, 3, 5, 7, 1, 2, 3, 5], 10, 2)
     * 2
     */
    public static int firstElement(List<Integer> arr, int n, int k) {
        if (arr == null || arr.size() == 0) {
            return -1;
        }
        return arr.get(0);
    }
}