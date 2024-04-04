import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class ModdivList {
    /**
     * * Write a function to find modulo division of two lists using map and lambda function.
     *
     * > moddivList([4, 5, 6], [1, 2, 3])
     * [0, 1, 0]
     * > moddivList([3, 2], [1, 4])
     * [0, 2]
     * > moddivList([90, 120], [50, 70])
     * [40, 50]
     */
    public static List<Integer> moddivList(List<Integer> nums1, List<Integer> nums2) {
        List<Integer> result = new ArrayList<>();
        int i = 0;
        while (i < nums1.size() && i < nums2.size()) {
            result.add(nums1.get(i) % nums2.get(i));
            i++;
        }
        return result;
    }
}