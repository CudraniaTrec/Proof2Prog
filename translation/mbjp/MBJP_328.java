import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class RotateLeft {
    /**
     * * Write a function to rotate a given list by specified number of items to the left direction.
     *
     * > rotateLeft([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], 3, 4)
     * [4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4]
     * > rotateLeft([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], 2, 2)
     * [3, 4, 5, 6, 7, 8, 9, 10, 1, 2]
     * > rotateLeft([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], 5, 2)
     * [6, 7, 8, 9, 10, 1, 2]
     */
    public static List<Integer> rotateLeft(List<Integer> list1, int m, int n) {
        List<Integer> result = new ArrayList<Integer>();
        for(int i=m; i<list1.size(); i++) {
            result.add(list1.get(i));
        }
        for(int i=0; i<n; i++) {
            result.add(list1.get(i));
        }
        return result;
    }
}