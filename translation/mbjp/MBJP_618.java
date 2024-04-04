import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class DivList {
    /**
     * * Write a function to divide two lists using map and lambda function.
     *
     * > divList([4, 5, 6], [1, 2, 3])
     * [4.0, 2.5, 2.0]
     * > divList([3, 2], [1, 4])
     * [3.0, 0.5]
     * > divList([90, 120], [50, 70])
     * [1.8, 1.7142857142857142]
     */
    public static List<Double> divList(List<Integer> nums1, List<Integer> nums2) {
        int size = nums1.size();
        List<Double> res = new ArrayList<Double>();
        for (int i = 0; i < size; i++) {
            res.add(nums1.get(i).doubleValue() / nums2.get(i).doubleValue());
        }
        return res;
    }
}