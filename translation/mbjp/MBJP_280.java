import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SequentialSearch {
    /**
     * * Write a function to search an element in the given array by using sequential search.
     *
     * > sequentialSearch([11, 23, 58, 31, 56, 77, 43, 12, 65, 19], 31)
     * [true, 3]
     * > sequentialSearch([12, 32, 45, 62, 35, 47, 44, 61], 61)
     * [true, 7]
     * > sequentialSearch([9, 10, 17, 19, 22, 39, 48, 56], 48)
     * [true, 6]
     */
    public static List<Object> sequentialSearch(List<Integer> dlist, int item) {
        boolean found = false;
        for (int i = 0; i < dlist.size(); i++) {
            if (item == dlist.get(i)) {
                found = true;
                break;
            }
        }
        return found ? Arrays.asList(true, dlist.indexOf(item)) : Arrays.asList(false, -1);
    }
}