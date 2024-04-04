import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;


class AddList {
    /**
     * * Write a function to add two lists using map and lambda function.
     *
     * > addList([1, 2, 3], [4, 5, 6])
     * [5, 7, 9]
     * > addList([1, 2], [3, 4])
     * [4, 6]
     * > addList([10, 20], [50, 70])
     * [60, 90]
     */
    public static List<Integer> addList(List<Integer> nums1, List<Integer> nums2) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (nums1 == null || nums2 == null) {
            return list;
        }
        for (int i = 0; i < nums1.size(); i++) {
            list.add(nums1.get(i) + nums2.get(i));
        }
        return list;
    }
}