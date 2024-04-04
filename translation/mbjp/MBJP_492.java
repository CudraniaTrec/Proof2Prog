import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class BinarySearch {
    /**
     * * Write a function to search an element in the given array by using binary search.
     *
     * > binarySearch([1, 2, 3, 5, 8], 6)
     * false
     * > binarySearch([7, 8, 9, 10, 13], 10)
     * true
     * > binarySearch([11, 13, 14, 19, 22, 36], 23)
     * false
     */
    public static Boolean binarySearch(List<Integer> itemList, int item) {
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i) == item) {
                return true;
            }
        }
        return false;
    }
}