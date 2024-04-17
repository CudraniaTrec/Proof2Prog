import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class AccessElements {
    /**
     * * Write a Java function to access multiple elements of specified index from a given list.
     *
     * > accessElements([2, 3, 8, 4, 7, 9], [0, 3, 5])
     * [2, 4, 9]
     * > accessElements([1, 2, 3, 4, 5], [1, 2])
     * [2, 3]
     * > accessElements([1, 0, 2, 3], [0, 1])
     * [1, 0]
     */
    public static List<Integer> accessElements(List<Integer> nums, List<Integer> listIndex) {
        List<Integer> result = new ArrayList<>();
        for (int i : listIndex) {
            if (nums.get(i) == null) {
                result.add(i);
            } else {
                result.add(nums.get(i));
            }
        }
        return result;
    }
}