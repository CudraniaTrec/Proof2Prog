import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class MulList {
    /**
     * * Write a function to multiply two lists using map and lambda function.
     *
     * > mulList([1, 2, 3], [4, 5, 6])
     * [4, 10, 18]
     * > mulList([1, 2], [3, 4])
     * [3, 8]
     * > mulList([90, 120], [50, 70])
     * [4500, 8400]
     */
    public static List<Integer> mulList(List<Integer> nums1, List<Integer> nums2) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = nums1.size();
        for (int i = 0; i < n; i++) {
            res.add(nums1.get(i) * nums2.get(i));
        }
        return res;
    }
}