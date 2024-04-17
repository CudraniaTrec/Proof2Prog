import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class SubList {
    /**
     * * Write a function to substaract two lists using map and lambda function.
     *
     * > subList([1, 2, 3], [4, 5, 6])
     * [-3, -3, -3]
     * > subList([1, 2], [3, 4])
     * [-2, -2]
     * > subList([90, 120], [50, 70])
     * [40, 50]
     */
    public static List<Integer> subList(List<Integer> nums1, List<Integer> nums2) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums1.size(); i++) {
            res.add(nums1.get(i) - nums2.get(i));
        }
        return res;
    }
}