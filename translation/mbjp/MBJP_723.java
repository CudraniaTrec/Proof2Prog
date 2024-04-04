import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class CountSamePair {
    /**
     * * Write a function to count the same pair in two given lists using map function.
     *
     * > countSamePair([1, 2, 3, 4, 5, 6, 7, 8], [2, 2, 3, 1, 2, 6, 7, 9])
     * 4
     * > countSamePair([0, 1, 2, -1, -5, 6, 0, -3, -2, 3, 4, 6, 8], [2, 1, 2, -1, -5, 6, 4, -3, -2, 3, 4, 6, 8])
     * 11
     * > countSamePair([2, 4, -6, -9, 11, -12, 14, -5, 17], [2, 1, 2, -1, -5, 6, 4, -3, -2, 3, 4, 6, 8])
     * 1
     */
    public static int countSamePair(List<Integer> nums1, List<Integer> nums2) {
        int res = 0;
        for (int i = 0; i < nums1.size(); i++) {
            res += nums1.get(i) == nums2.get(i) ? 1 : 0;
        }
        return res;
    }
}