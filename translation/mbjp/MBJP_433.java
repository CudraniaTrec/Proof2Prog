import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CheckGreater {
    /**
     * * Write a function to check whether the entered number is greater than the elements of the given array.
     *
     * > checkGreater([1, 2, 3, 4, 5], 4)
     * "No, entered number is less than those in the array"
     * > checkGreater([2, 3, 4, 5, 6], 8)
     * "Yes, the entered number is greater than those in the array"
     * > checkGreater([9, 7, 4, 8, 6, 1], 11)
     * "Yes, the entered number is greater than those in the array"
     */
    public static String checkGreater(List<Integer> arr, int number) {
        String result = "No, entered number is less than those in the array";
        if (arr.size() == 0) {
            return result;
        }
        for (Integer i : arr) {
            if (i > number) {
                return result;
            }
        }
        return "Yes, the entered number is greater than those in the array";
    }
}