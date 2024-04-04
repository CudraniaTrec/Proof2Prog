import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class IntersectionArray {
    /**
     * * Write a function to find the intersection of two arrays using lambda function.
     *
     * > intersectionArray([1, 2, 3, 5, 7, 8, 9, 10], [1, 2, 4, 8, 9])
     * [1, 2, 8, 9]
     * > intersectionArray([1, 2, 3, 5, 7, 8, 9, 10], [3, 5, 7, 9])
     * [3, 5, 7, 9]
     * > intersectionArray([1, 2, 3, 5, 7, 8, 9, 10], [10, 20, 30, 40])
     * [10]
     */
    public static List<Integer> intersectionArray(List<Integer> arrayNums1, List<Integer> arrayNums2) {
        List<Integer> res = new ArrayList<>();

        for (Integer i : arrayNums1) {
            if (arrayNums2.contains(i)) {
                res.add(i);
            }
        }
        return res;
    }
}